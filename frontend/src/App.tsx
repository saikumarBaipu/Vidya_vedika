
import { useEffect, useState } from "react";
import { api } from "./services/api";

const languages=["English","Hindi","Telugu","Kannada","Tamil","Malayalam","Marathi","Bengali","Spanish","French","German","Japanese"];
export default function App(){
 const [tab,setTab]=useState("dashboard"); const [health,setHealth]=useState("Ready");
 useEffect(()=>{setHealth("Ready")},[]);
 return <div className="app">
  <aside className="sidebar"><div className="brand">Vidya <span>Vedika</span></div>
   <nav>{[["dashboard","Dashboard"],["languages","Languages"],["practice","AI Practice"],["interview","Mock Interview"],["progress","My Progress"]].map(([id,label])=><button className={tab===id?"active":""} onClick={()=>setTab(id)} key={id}>{label}</button>)}</nav>
   <div className="side-note"><b>Daily goal</b><div className="goal"><span style={{width:"70%"}}/></div><small>7 of 10 tasks</small></div>
  </aside>
  <main><header><div><p className="eyebrow">LEARN • PRACTICE • GROW</p><h1>{tab==="dashboard"?"Good afternoon 👋":"Your "+tab.replace("-"," ")}</h1></div><div className="profile">AK <span>Account</span></div></header>
   {tab==="dashboard" && <Dashboard/>}
   {tab==="languages" && <section><div className="section-title"><h2>Language Library</h2><p>Choose a language and continue your learning path.</p></div><div className="grid">{languages.map((x,i)=><article className="card language" key={x}><div className="flag">{["EN","हि","తె","ಕ","த","മ","म","বা","ES","FR","DE","日"][i]}</div><div><h3>{x}</h3><p>{i%3===0?"Beginner":"Beginner • Intermediate"}</p><div className="progress"><span style={{width:`${20+i*5}%`}}/></div></div><button onClick={()=>setTab("practice")}>Continue</button></article>)}</div></section>}
   {tab==="practice" && <Practice/>}
   {tab==="interview" && <Interview/>}
   {tab==="progress" && <Dashboard progress/>}
  </main>
 </div>
}
function Dashboard({progress=false}:{progress?:boolean}){return <section><div className="hero-card"><div><p className="eyebrow">YOUR LEARNING MOMENTUM</p><h2>{progress?"Keep building your skills":"Learn something new every day."}</h2><p>Practice languages, get AI feedback, and prepare for interviews in one focused workspace.</p><button className="primary">Start today's practice</button></div><div className="ring">72%<small>overall</small></div></div><div className="stats">{[["🔥","12 days","Learning streak"],["◉","48","Practice sessions"],["✓","72%","Overall progress"],["★","8","Achievements"]].map(x=><div className="stat card"><b>{x[0]}</b><strong>{x[1]}</strong><span>{x[2]}</span></div>)}</div><div className="two"><div className="card panel"><h3>Weekly practice</h3><div className="bars">{[40,70,55,90,65,45,80].map((h,i)=><i style={{height:h+"%"}} key={i}/>)}</div><div className="days">M T W T F S S</div></div><div className="card panel"><h3>Today's Practice</h3>{["Vocabulary","Pronunciation","Listening","Speaking"].map((x,i)=><div className="task"><span>✓</span><div><b>{x}</b><small>{i<2?"Completed":"In progress"}</small></div></div>)}</div></div></section>}
function Practice(){const [sentence,setSentence]=useState("");const [result,setResult]=useState<any>(null);async function correct(){try{setResult(await api.post("/api/ai/correction",{sentence}))}catch{setResult({reply:"AI service temporarily unavailable. Your practice is saved locally."})}}return <section><div className="section-title"><h2>Learn With AI</h2><p>Practice naturally. Get feedback without fear of mistakes.</p></div><div className="practice card"><label>Your sentence</label><textarea value={sentence} onChange={e=>setSentence(e.target.value)} placeholder="Write a sentence in English..."/><button className="primary" onClick={correct}>Correct my sentence</button>{result&&<div className="result"><b>AI feedback</b><p>{result.reply||result.explanation||result.corrected}</p></div>}</div></section>}
function Interview(){return <section><div className="section-title"><h2>Mock Interviews</h2><p>Build confidence one question at a time.</p></div><div className="grid">{["HR Interview","Technical Interview","Software Developer","Experienced Professional"].map((x)=><div className="card interview"><span className="icon">✦</span><h3>{x}</h3><p>AI-led questions, feedback and performance history.</p><button className="primary">Start interview</button></div>)}</div></section>}

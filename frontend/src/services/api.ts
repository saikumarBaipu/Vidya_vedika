
import axios from "axios";
const client=axios.create({baseURL:import.meta.env.VITE_API_URL||"http://localhost:8080",timeout:10000,headers:{"Content-Type":"application/json"}});
client.interceptors.request.use(c=>{const t=localStorage.getItem("accessToken");if(t)c.headers.Authorization=`Bearer ${t}`;return c});
export const api={get:async<T=any>(url:string)=> (await client.get<T>(url)).data,post:async<T=any>(url:string,data:any)=> (await client.post<T>(url,data)).data,put:async<T=any>(url:string,data:any)=> (await client.put<T>(url,data)).data};
export default client;

import {createApp} from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from 'vue-router'
import Home from "@/pages/Home.vue";
import Join from "@/pages/Join.vue"


const routes = [
    {path: '/', component: Home},
    {path : '/join' , component: Join}
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

createApp(App).use(router).mount('#app')

const app = Vue.createApp({

    data() {
        return {
            name : 'Lee',
            age : 30,
            urlLink : 'https://i.ytimg.com/vi/43KQnP81jyw/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCIGO5kyuZcNEhV2IaHiLB7-bp8Hg'
        }
    },
    methods: {
        randomNumber : function(){
            return Math.random();
        }
    }
})

app.mount('#assignment');
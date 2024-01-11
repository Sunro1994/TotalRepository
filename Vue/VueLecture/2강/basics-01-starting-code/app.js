const app = Vue.createApp({
    data() {
        return {
            courseGoalA : 'finish Vue',
            cousreGoalB : 'Master Vue and build amazing app',
            cousreGoalC : '<h3>Utilize Vue</h3>',
            vueLink : 'https://vuejs.org/'
        }
    },
    methods: {
      outputGoal : function(){
        const randomNumber = Math.random();
        if(randomNumber<0.5){
            return this.courseGoalA;
        }else{
            return this.cousreGoalB;
        }
      }  
    },
})

app.mount('#user-goal');
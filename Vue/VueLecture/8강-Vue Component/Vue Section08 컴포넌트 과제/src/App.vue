<template>
  <section id="app">
    <active-user :username="user.name" :userage="user.age"></active-user>
    <user-data @set-data="setUserData"></user-data>
  </section>
</template>


<script>
import ActiveUser from './components/ActiveUser.vue'
import UserData from './components/UserData.vue'
    export default{
  components: { ActiveUser, UserData },
  data(){
    return{
      user:{
        name: 'sunro',
        age: 31
      }
    }
  },
  methods:{
    setUserData(name,age){
        this.user = {
          name: name,
          age: +age
        };
    }
  }

    }
</script>
<style>
section {
  margin: 2rem auto;
  max-width: 40rem;
  border-radius: 20px;
  border: 1px solid #ccc;
}

</style>
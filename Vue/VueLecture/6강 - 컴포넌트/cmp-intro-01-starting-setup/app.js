const app = Vue.createApp({
    data(){
        return {
            friends : [
                {
                    id : 'manuel', 
                    name: 'Manuel Lorenz', 
                    phone : '01234 566778 991',
                    email : 'manuel@localhost.com'
            },{
                id : 'julie', 
                name: 'julie Lorenz', 
                phone : '123 566778 991',
                email : 'julie@localhost.com'
            },
            ]
        }
    },
    


});

app.component('friend-contact',{
    template :
    `<li>
    <h2>{{friend.name}}</h2>
    <button @click="toggleDetails(friend.id)">{{ detailsAreVisible? 'Hide' : 'Show'}} Details</button>
    <ul v-if="detailsAreVisible">
      <li ><strong>Phone:</strong> {{friend.phone}}</li>
      <li><strong>Email:</strong> {{friend.email}}</li>
    </ul>
  </li>` ,
    data(){
        return {
            friend:{
                id : 'julie', 
                name: 'julie Lorenz', 
                phone : '123 566778 991',
                email : 'julie@localhost.com'
            },
            detailsAreVisible : false
        };
    },
    methods:{
        toggleDetails(){
            this.detailsAreVisible = !this.detailsAreVisible;
        }
    }
}); //두개의 인수를 갖는다.

app.mount('#app');
const app = Vue.createApp({
    data(){
        return{
            alertContent:'Alert executed!',
            outputContent : '',
            outputContent2 : ''
        }
    },
    methods: {
        alertButton: function(){
            return alert(this.alertContent);
        },
        saveInput(event){
            this.outputContent = event.target.value;
        },
        updateInput(){
            this.outputContent2=this.outputContent;
        }
        }
    },
)

app.mount('#assignment');
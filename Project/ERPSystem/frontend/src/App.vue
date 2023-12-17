<template>
  <RouterView/>
</template>

<script>

export default {
  name: 'App',
  methods: {
    switchToLogin() {
      this.$refs.loginForm.style.marginLeft = '0%';
      this.$refs.signupForm.style.marginLeft = '-50%';
    },
    switchToSignup() {
      this.$refs.loginForm.style.marginLeft = '-50%';
      this.$refs.signupForm.style.marginLeft = '0%';
    }
  }
}
</script>



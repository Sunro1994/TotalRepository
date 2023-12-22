<template>
  <form>
    <input type="text" name="userId" placeholder="ID" required>
    <input type="password" name="userPw" placeholder="PW" required>
    <input type="text" name="name" placeholder="Name" required>
    <input type="email" name="email" placeholder="test@email.com" required>
    <input type="number" name="age" min="1" max="90" required>
    <input type="text" name="address" placeholder="Address">
    <input type="text" name="number" placeholder="000-0000-0000" required>
    <input type="radio" name="gender" value="man">
    <input type="date" name="birth" required/>
  </form>
</template>

<script>
export  default{
  name : "Join"
}

</script>
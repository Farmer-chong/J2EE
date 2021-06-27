<template>
  <div id="login">
    <div class="form">
      <a href="/.">-Farmer Login Demo</a>
      <h4>欢迎登录EasyLoginDemo</h4>
      <input type="text" placeholder="UserName" v-model="user.username" />
      <input
        type="password"
        placeholder="Password"
        v-model="user.password"
        @keyup.enter="login"
      />
      <button @click="login">登录</button>
    </div>
  </div>
</template>
<script>
import apiConf from "../api/apiConfig";
export default {
  data() {
    return {
      user: {
        username: "admin",
        password: "admin",
      },
    };
  },
  methods: {
    async login() {
      const conf = apiConf.Auth.login(this.user.username, this.user.password);
      try {
        const data = await this.$axios(conf)
        // console.log(data)
        const token = data.data.data.token
        // console.log(this.$store.getters.token)
        await this.$store.commit('set', token);
        // const local_token = localStorage.getItem('token')
        // console.log('lt', local_token)
        localStorage.setItem("token", token);
        // console.log('lt', localStorage.getItem('token'))
        this.$router.push("/admin");
      } catch (error) {
        console.log('err', error)
      }
    },
  },
};
</script>
<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 15px;
}

/* #login{
    background-color: #efefef;
} */

h4 {
  font-size: 18px;
  padding: 15px;
}

.form {
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  height: 100vh;
  width: 80vw;
}

button,
.form input {
  outline: 0;
  margin: 0 0 15px;
  box-sizing: border-box;
  font-size: 14px;
  border: 0;
  width: 25vw;
  max-width: 335px;
  min-width: 200px;
  padding: 10px;
  /* background-color: #efefef; */
  border-bottom: 1px solid #1890ff;
}

input:focus {
  border-radius: 5px;
  border: 1px solid #1890ff;
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075),
    0 0 8px rgba(102, 175, 233, 0.6);
}

button {
  font-size: 15px;
  color: #ffffff;
  background-color: #419cf1;
}

button:hover {
  cursor: pointer;
  background: #0285ff;
  border-color: #0285ff;
  color: #ffffff;
}

a,
a:link,
a:visited,
a:hover,
a:active {
  text-decoration: none;
  font-size: 64px;
  color: rgb(228, 228, 228);
  padding: 15px;
}
</style>

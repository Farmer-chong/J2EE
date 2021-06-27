import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from './axios.config'

Vue.config.productionTip = false

Vue.prototype.$axios = axios

if (localStorage.getItem('token')) {
  const token = `${localStorage.getItem('token')}`
  // console.log(token)
  store.commit('set', token)
  // console.log(token)
}

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

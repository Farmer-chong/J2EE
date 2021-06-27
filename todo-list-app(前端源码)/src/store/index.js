import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: null
  },
  getters: {
    token: state => {
      return state.token
    }
  },
  mutations: {
    set (state, jwt) {
      state.token = jwt
    }
  },
  actions: {

  },
  modules: {
  }
})

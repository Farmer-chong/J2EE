import axios from 'axios'
import apiConfig from '@/api/apiConfig'
import store from '@/store'
// import mdui from 'mdui'

axios.defaults.baseURL = `${apiConfig.server}`
// axios.defaults.timeout = 30000
// axios.defaults.withCredentials = true
axios.defaults.headers['Content-Type'] = 'application/json'

// 添加请求拦截器
axios.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  if (store.getters.token != null) {
    config.headers.Authorization = `${apiConfig.token_prefix}${store.getters.token}`
  }
  return config
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error)
})

// axios响应拦截器 拦截所有错误请求
axios.interceptors.response.use(
  conf => {
    if (conf.data.code >= 0) {
      return conf
    }
    return Promise.reject(conf.data)
  },
  err => {
    try {
      console.log(err.response)
      if (err.response.data.code === 401) {
        console.log('remove token...')
        localStorage.clear()
        return "token err"
      }
    } catch (error) {
      console.log('resp err', error)
      return "网络错误"
    }
    return err.response
  }
)
export default axios

const apiConfig = {
    // 反代服务器地址
    proxyServer: 'http://farmer233.asuscomm.com:8082/api',
    // api服务器地址
    // server: 'http://127.0.0.1:8082/api',
    server: 'http://farmer233.asuscomm.com:8082/api',

    // token前缀
    token_prefix: 'Bearer ',

    // User
    Auth: {
        login(user, passwd) {
            return {
                method: 'post',
                url: '/auth/login',
                data: {
                    username: user,
                    password: passwd
                }
            }
        },
        regUser(email, user, passwd) {
            return {
                method: 'post',
                url: '/auth/reg',
                data: {
                  username: user,
                  password: passwd,
                  email: email
                }
              }
        }
    },

    // todoList
    TodoList: {
        setTodo(task, state, completed){
            return {
                method: 'POST',
                url: '/todoList/setTodoList',
                data: {
                    task: task,
                    state: state,
                    completed: completed
                }
            }
        },
        getTodo() {
            return {
                method: "get",
                url: '/todoList/getTodoList'
            }
        },
        modify(item) {
            return {
                method: "post",
                url: '/todoList/modifyTask',
                data: {
                    "id": item.id,
                    "task": item.task,
                    "state": item.state,
                    "completed": item.completed
                }
            }
        },
        delTodo(item) {
            return {
                method: "post",
                url: '/todoList/del',
                data: {
                    "taskId": item.id
                }
            }
        }
    },
    Guest: {
        getTodos (username) {
            return {
                method: 'get',
                url: `/guest/getTodos?username=${username}`
            }
        }
    }
}

module.exports = apiConfig

<template>
  <main>
    <div class="container">
      <h1>欢迎使用 Todo List !</h1>
      <todoAdd @add-todo="addTodo"></todoAdd>
      <TodoFilter
        :selected="filter"
        @change-filter="filter = $event"
      ></TodoFilter>
      <TodoList :todos="filteredTodos"></TodoList>
    </div>
  </main>
</template>

<script>
// @ is an alias to /src
import todoAdd from '../components/TodoAdd.vue'
import TodoFilter from "../components/TdoFilter";
import TodoList from "../components/TodoListAdmin";
import apiConfig from '../api/apiConfig';

export default {
  name: 'Admin',
  data () {
    return {
      todoList: [],
      todoComponent: {
        id: -1,
        task: "",
        state: 0,
        completed: false
      },
      filter: "all",
    }
  },
  computed: {
    filteredTodos () {
      switch (this.filter) {
        case "done":
          return this.todoList.filter((todo) => todo.completed);
        case "todo":
          return this.todoList.filter((todo) => !todo.completed);
        default:
          return this.todoList;
      }
    }
  },
  methods: {
    async addTodo (task) {
      // 调用api()
      const conf = apiConfig.TodoList.setTodo(task, 0, false)
      const data = await this.$axios(conf)
      console.log({...this.todoComponent, ...{"task": task, "id": data.data.data.id}})
      this.todoList.push(
        {...this.todoComponent, ...{"task": task, "id": data.data.data.id}}
      )
    },
    getTodoList(){
      const conf = apiConfig.TodoList.getTodo()
      this.$axios(conf).then(data => {
        const items = data.data.data
        this.todoList = items
      }).catch(e => console.log(e))
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.getTodoList()
    })
  },
  components: {
    todoAdd,
    TodoFilter,
    TodoList
  }
}
</script>

<style>
</style>
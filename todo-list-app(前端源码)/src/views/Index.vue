<template>
  <main>
    <div class="container">
      <h1>欢迎使用 Todo List !</h1>
      <todoAdd :username="this.tips" @add-todo="addTodo"></todoAdd>
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
import todoAdd from "../components/TodoAdd.vue";
import TodoFilter from "../components/TdoFilter";
import TodoList from "../components/TodoList";
import apiConfig from "../api/apiConfig";

export default {
  name: "Index",
  data() {
    return {
      todoList: [],
      todoComponent: {
        id: -1,
        task: "",
        state: 0,
        completed: false,
      },
      filter: "all",
      tips: 'Enter user name'
    };
  },
  computed: {
    filteredTodos() {
      switch (this.filter) {
        case "done":
          return this.todoList.filter((todo) => todo.completed);
        case "todo":
          return this.todoList.filter((todo) => !todo.completed);
        default:
          return this.todoList;
      }
    },
  },
  methods: {
    addTodo(username) {
      // 调用api()
      console.log(username)
      const conf = apiConfig.Guest.getTodos(username)
      this.$axios(conf).then(data => {
        console.log(data.data.data)
        this.todoList = data.data.data
        this.tips = ''
      })
    },
    getTodoList() {
      const conf = apiConfig.TodoList.getTodo();
      this.$axios(conf)
        .then((data) => {
          const items = data.data.data;
          this.todoList = items.filter((e) => {
            return e.state != -1;
          });
          console.log(this.todoList);
        })
        .catch((e) => console.log(e));
    },
  },
  mounted() {
    this.$nextTick(() => {
      this.getTodoList();
    });
  },
  components: {
    todoAdd,
    TodoFilter,
    TodoList,
  },
};
</script>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-family: Avenir, Helvetica, "PingFang SC", "Microsoft Yahei", sans-serif;
}

main {
  width: 100vw;
  min-width: 600px;
  min-height: 100vh;
  display: grid;
  align-items: center;
  justify-items: center;
  background: rgb(203, 210, 240);
}

.container {
  width: 60%;
  max-width: 400px;
  box-shadow: 0px 0px 24px rgba(0, 0, 0, 0.15);
  border-radius: 24px;
  padding: 48px 28px;
  background-color: rgb(245, 245, 252);
}

h1 {
  margin: 24px 0;
  font-size: 26px;
  color: #414873;
}
</style>
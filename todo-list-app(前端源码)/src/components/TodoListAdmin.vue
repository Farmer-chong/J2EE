<template>
  <div class="todo-list">
    <todo-list-item
      v-for="todo in getTodos"
      :key="todo.id"
      :todo-item="todo"
      @change-state="check($event, todo)"
      @del-item="delItem"
    ></todo-list-item>
  </div>
</template>

<script>
import apiConfig from '../api/apiConfig';
import TodoListItem from "./TodoListItemAdmin";

export default {
  name: "TodoListAdmin",
  components: { TodoListItem },
  props: ["todos"],
  computed: {
    getTodos () {
      return this.todos.filter(e => {
        return e.state != -1
      })
    }
  },
  methods: {
    delItem(item){
      item.state = -1
      const conf = apiConfig.TodoList.delTodo(item)
      this.$axios(conf).then(value => {
        console.log(value)
      }).catch(e => console.log('err', e))
    },
    check ($event, todo) {
      todo.completed = $event.target.checked
    }
  }
};
</script>

<style>
.todo-list {
  display: grid;
  row-gap: 14px;
}
</style>
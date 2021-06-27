<template>
  <div class="input-add">
    <input
      type="text"
      name="todo"
      v-model="todoContent"
      @keyup.enter="emitAddTodo"
      :placeholder='username'
    />
    <button @click="emitAddTodo">
      <i class="plus"></i>
    </button>
  </div>
</template>

<script>
export default {
  name: "TodoAdd",
  data () {
    return {
      todoContent: ''
    }
  },
  props:['username'],
  computed: {
    getTips () {
      return this.username || ''
    }
  },
  methods: {
    async emitAddTodo () {
      try {
        this.todoContent.length !== 0 ? this.$emit("add-todo", this.todoContent) : null
        this.todoContent = ''
      } catch (error) {
        console.log(error)
      }
    },

  }
};
</script>

<style>
.input-add {
  position: relative;
  display: flex;
  align-items: center;
}

.input-add input {
  padding: 16px 52px 16px 18px;
  border-radius: 48px;
  border: none;
  outline: none;
  box-shadow: 0px 0px 24px rgba(0, 0, 0, 0.08);
  width: 100%;
  font-size: 16px;
  color: #626262;
}

.input-add button {
  width: 46px;
  height: 46px;
  border-radius: 50%;
  background: linear-gradient(#c0a5f3, #7f95f7);
  border: none;
  outline: none;

  color: white;
  position: absolute;
  right: 0px;
  /* 鼠标指针->小手 */
  cursor: pointer;
}

.input-add .plus {
  display: block;
  width: 100%;
  height: 100%;
  background: linear-gradient(#fff, #fff), linear-gradient(#fff, #fff);
  background-size: 50% 2px, 2px 50%;
  background-position: center;
  background-repeat: no-repeat;
}
</style>
<template>
  <div
    class="todo-item"
    @mousedown.stop="mouseDown"
    :class="{ done: todoItem.completed }">
    <label >
      <input
        type="checkbox"
        :checked="todoItem.completed"
        @click="changeState($event)"
      />
      {{ todoItem.task }}
      <span class="check-button"></span>
    </label>
  </div>
</template>

<script>

import apiConfig from '../api/apiConfig';
export default {
  name: "TodoListItemAdmin",
  props: ["todoItem"],
  methods: {
    changeState ($event) {
      this.$emit('change-state', $event)
      const conf = apiConfig.TodoList.modify(this.todoItem)
      this.$axios(conf).then(value => {
        console.log(value)
      })
    },
    mouseDown($e){
      console.log("鼠标按下", $e.target.style)
      // console.log($e.target.style)
      const moveFunc = ($evn) => {
        console.log('move')
        // console.log('basePoint', $e.clientX, 'nowPoint', $evn.clientX)
        $e.target.style.left = `${$evn.clientX - $e.clientX}px`
        // $e.target.style.transform = `translateX(${$evn.clientX - $e.clientX}px)`
        // const isDel = Math.abs($e.clientX - $evn.clientX) > 100 ? true : false
        // console.log(isDel)
      }

      const upFunc = ($evn) => {
        console.log('up')
        // const basePoint = $e.clientX
        const isDel = Math.abs($e.clientX - $evn.clientX) > 100 ? true : false
        console.log(isDel)
        if(isDel){
          this.delItem()
        }
        // $.target.removeEventListener("mousedown", this.mouseDown)
        $e.target.removeEventListener("mousemove", moveFunc)
        document.body.removeEventListener("mouseup", upFunc)
        $e.target.style.left = ""
      }

      $e.target.addEventListener("mousemove", moveFunc, false)
      document.body.addEventListener("mouseup", upFunc, false)

    },
    delItem(){
      this.$emit('del-item', this.todoItem)
    }
  }
};
</script>

<style>
.todo-item {
  background: white;
  padding: 16px;
  border-radius: 8px;
  color: #626262;
}

.todo-item label {
  position: relative;
  display: flex;
  align-items: center;
  cursor: pointer;
}

.todo-item.done label {
  text-decoration: line-through;
  font-style: italic;
}

.todo-item label span.check-button {
  position: absolute;
  top: 0;
}

.todo-item label span.check-button::before,
.todo-item label span.check-button::after {
  content: "";
  display: block;
  position: absolute;
  width: 18px;
  height: 18px;
  border-radius: 50%;
}

.todo-item label span.check-button::before {
  border: 1px solid #b382f9;
}

.todo-item label span.check-button::after {
  transition: 0.4s;
  background: #b382f9;
  transform: translate(1px, 1px) scale(0.8);
  opacity: 0;
}

.todo-item input {
  margin-right: 16px;
  opacity: 0;
}

.todo-item input:checked + span.check-button::after {
  opacity: 1;
}
</style>
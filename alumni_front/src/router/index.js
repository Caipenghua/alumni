import Vue from 'vue'
import Router from 'vue-router'
import Alumni from '@/components/Alumni'
import AddAlumni from '@/components/AddAlumni'
import UpdateAlumni from '@/components/UpdateAlumni'
import addPost from '@/components/addPost'
import Post from '@/components/Post'
import PostDetail from '@/components/PostDetail'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Alumni',
      component: Alumni
    },
    {
      path: '/addAlumni',
      name: 'AddAlumni',
      component: AddAlumni
    },
    {
      path: '/updateAlumni/:id',
      name: 'updateAlumni',
      component: UpdateAlumni
    },
    {
      path: '/Post',
      name: 'Post',
      component: Post
    },
    {
      path: '/addPost',
      name: 'addPost',
      component: addPost
    },
    {
      path: '/postDetail/:id',
      name: 'postDetail',
      component: PostDetail
    }
  ]
})

import Vue from 'vue'
import Router from 'vue-router'
import Alumni from '@/components/Alumni'
import AddAlumni from '@/components/AddAlumni'
import UpdateAlumni from '@/components/UpdateAlumni'
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
    }
  ]
})

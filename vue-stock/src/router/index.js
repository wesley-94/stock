import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CreateMemberView from '../views/members/createMemberForm.vue';
import MemberListView from '../views/members/MemberList.vue';
import NotFoundView from '../views/NotFoundView.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/members/new',
    name: 'CreateMember',
    component: CreateMemberView,
  },
  {
    path: '/members',
    name: 'MemberList',
    component: MemberListView,
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFoundView,
  }
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  // history: createWebHistory(),
  routes,
})

export default router;

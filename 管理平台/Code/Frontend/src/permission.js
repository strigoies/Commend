// import router from './router'
// import store from './store'
// import { Message } from 'element-ui'
// import NProgress from 'nprogress' 
// import 'nprogress/nprogress.css' 
// import { getToken } from '@/utils/auth'
// //import getPageTitle from '@/utils/get-page-title'

// NProgress.configure({ showSpinner: false })

// const whiteList = ['/login']

// router.beforeEach(async(to, from, next) => {

//   NProgress.start()
//   //document.title = getPageTitle(to.meta.title)
//   //const hasToken = getToken()
// const hasToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWxpLXVzZXIiLCJpYXQiOjE2NTMzOTE4NjIsImV4cCI6MTY1MzQ3ODI2MiwiaWQiOiIxNTI4NjQ0Nzk1MzMwMjg1NTY5Iiwibmlja25hbWUiOiJzdHJpbmcifQ.aVnmAdPFGbYZrQkZgCWyIHhKJOJON8KWzDowhEfOr-M"
//   if (hasToken) {
//     if (to.path === '/login') {
//       next({ path: '/' })
//       NProgress.done()
//     } else {
//       const hasRoles = store.getters.roles && store.getters.roles.length > 0 // 1. 根据用户是否具有权限列表，判断用户时候已经登录
//       if (hasRoles) {
//         next()
//       } else {
//         try {
        
//           const { roles } = await store.dispatch('user/getInfo')          // 2. 首次登录从用户信息中获取用户权限列表
//           const accessRoutes = await store.dispatch('permission/generateRoutes', roles)   // 3. 根据用户权限列表生成用户可访问动态路由表
//           router.addRoutes(accessRoutes)                    // 4. 将用户动态路由表挂载到 router
          
//           next({ ...to, replace: true })
//         } catch (error) {
//           await store.dispatch('user/resetToken')
//           Message.error(error || 'Has Error')
//           next(`/login?redirect=${to.path}`)
//           NProgress.done()
//         }
//       }
//     }
//   } else {
//     /* has no token*/
//     if (whiteList.indexOf(to.path) !== -1) {
//       next()
//     } else {
//       next(`/login?redirect=${to.path}`)
//       NProgress.done()
//     }
//   }
// })

// router.afterEach(() => {
//   NProgress.done()
// })
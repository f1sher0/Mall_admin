import { createRouter, createWebHistory } from 'vue-router'
import Dashboard from './pages/Dashboard.vue'
import Analytics from './pages/Analytics.vue'
import Fintech from './pages/Fintech.vue'
import Customers from './pages/ecommerce/Customers.vue'
import Orders from './pages/ecommerce/Orders.vue'
import Invoices from './pages/ecommerce/Invoices.vue'
import Shop from './pages/ecommerce/Shop.vue'
import Shop2 from './pages/ecommerce/Shop2.vue'
import Product from './pages/ecommerce/Product.vue'
import Cart from './pages/ecommerce/Cart.vue'
import Cart2 from './pages/ecommerce/Cart2.vue'
import Cart3 from './pages/ecommerce/Cart3.vue'
import Pay from './pages/ecommerce/Pay.vue'
import Campaigns from './pages/Campaigns.vue'
import UsersTabs from './pages/community/UsersTabs.vue'
import UsersTiles from './pages/community/UsersTiles.vue'
import Profile from './pages/community/Profile.vue'
import Feed from './pages/community/Feed.vue'
import Forum from './pages/community/Forum.vue'
import ForumPost from './pages/community/ForumPost.vue'
import Meetups from './pages/community/Meetups.vue'
import MeetupsPost from './pages/community/MeetupsPost.vue'
import CreditCards from './pages/finance/CreditCards.vue'
import Transactions from './pages/finance/Transactions.vue'
import TransactionDetails from './pages/finance/TransactionDetails.vue'
import JobListing from './pages/job/JobListing.vue'
import JobPost from './pages/job/JobPost.vue'
import CompanyProfile from './pages/job/CompanyProfile.vue'
import Messages from './pages/Messages.vue'
import TasksKanban from './pages/tasks/TasksKanban.vue'
import TasksList from './pages/tasks/TasksList.vue'
import Inbox from './pages/Inbox.vue'
import Calendar from './pages/Calendar.vue'
import Account from './pages/settings/Account.vue'
import Notifications from './pages/settings/Notifications.vue'
import Apps from './pages/settings/Apps.vue'
import Plans from './pages/settings/Plans.vue'
import Billing from './pages/settings/Billing.vue'
import Feedback from './pages/settings/Feedback.vue'
import Changelog from './pages/utility/Changelog.vue'
import Roadmap from './pages/utility/Roadmap.vue'
import Faqs from './pages/utility/Faqs.vue'
import EmptyState from './pages/utility/EmptyState.vue'
import PageNotFound from './pages/utility/PageNotFound.vue'
import KnowledgeBase from './pages/utility/KnowledgeBase.vue'
import Signin from './pages/Signin.vue'
import Signup from './pages/Signup.vue'
import ResetPassword from './pages/ResetPassword.vue'
import Onboarding01 from './pages/Onboarding01.vue'
import Onboarding02 from './pages/Onboarding02.vue'
import Onboarding03 from './pages/Onboarding03.vue'
import Onboarding04 from './pages/Onboarding04.vue'
import ButtonPage from './pages/component/ButtonPage.vue'
import FormPage from './pages/component/FormPage.vue'
import DropdownPage from './pages/component/DropdownPage.vue'
import AlertPage from './pages/component/AlertPage.vue'
import ModalPage from './pages/component/ModalPage.vue'
import PaginationPage from './pages/component/PaginationPage.vue'
import TabsPage from './pages/component/TabsPage.vue'
import BreadcrumbPage from './pages/component/BreadcrumbPage.vue'
import BadgePage from './pages/component/BadgePage.vue'
import AvatarPage from './pages/component/AvatarPage.vue'
import TooltipPage from './pages/component/TooltipPage.vue'
import AccordionPage from './pages/component/AccordionPage.vue'
import IconsPage from './pages/component/IconsPage.vue'
import { useAuthStore } from './stores/auth';

const routerHistory = createWebHistory()

const router = createRouter({
  history: routerHistory,
  routes: [
    {
      path: '/',
      component: Dashboard,
      meta: { requiresAuth: true }
    },
    {
      path: '/dashboard/analytics',
      component: Analytics,
      meta: { requiresAuth: true }
    },
    {
      path: '/dashboard/fintech',
      component: Fintech,
      meta: { requiresAuth: true }
    },    
    {
      path: '/ecommerce/customers',
      component: Customers,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/orders',
      component: Orders,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/invoices',
      component: Invoices,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/shop',
      component: Shop,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/shop-2',
      component: Shop2,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/product',
      component: Product,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/cart',
      component: Cart,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/cart-2',
      component: Cart2,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/cart-3',
      component: Cart3,
      meta: { requiresAuth: true }
    },
    {
      path: '/ecommerce/pay',
      component: Pay,
      meta: { requiresAuth: true }
    },
    {
      path: '/campaigns',
      component: Campaigns,
      meta: { requiresAuth: true }
    },
    {
      path: '/community/users-tabs',
      component: UsersTabs,
      meta: { requiresAuth: true }
    },
    {
      path: '/community/users-tiles',
      component: UsersTiles,
      meta: { requiresAuth: true }
    },
    {
      path: '/community/profile',
      component: Profile,
      meta: { requiresAuth: true }
    },
    {
      path: '/community/feed',
      component: Feed,
      meta: { requiresAuth: true }
    },
    {
      path: '/community/forum',
      component: Forum,
      meta: { requiresAuth: true }
    },
    {
      path: '/community/forum-post',
      component: ForumPost,
      meta: { requiresAuth: true }
    },    
    {
      path: '/community/meetups',
      component: Meetups,
      meta: { requiresAuth: true }
    },
    {
      path: '/community/meetups-post',
      component: MeetupsPost,
      meta: { requiresAuth: true }
    },
    {
      path: '/finance/cards',
      component: CreditCards,
      meta: { requiresAuth: true }
    }, 
    {
      path: '/finance/transactions',
      component: Transactions,
      meta: { requiresAuth: true }
    },
    {
      path: '/finance/transaction-details',
      component: TransactionDetails,
      meta: { requiresAuth: true }
    },
    {
      path: '/job/job-listing',
      component: JobListing,
      meta: { requiresAuth: true }
    },
    {
      path: '/job/job-post',
      component: JobPost,
      meta: { requiresAuth: true }
    },
    {
      path: '/job/company-profile',
      component: CompanyProfile,
      meta: { requiresAuth: true }
    },            
    {
      path: '/messages',
      component: Messages,
      meta: { requiresAuth: true }
    },
    {
      path: '/tasks/kanban',
      component: TasksKanban,
      meta: { requiresAuth: true }
    },
    {
      path: '/tasks/list',
      component: TasksList,
      meta: { requiresAuth: true }
    },    
    {
      path: '/inbox',
      component: Inbox,
      meta: { requiresAuth: true }
    },
    {
      path: '/calendar',
      component: Calendar,
      meta: { requiresAuth: true }
    },
    {
      path: '/settings/account',
      component: Account,
      meta: { requiresAuth: true }
    },
    {
      path: '/settings/notifications',
      component: Notifications,
      meta: { requiresAuth: true }
    },
    {
      path: '/settings/apps',
      component: Apps,
      meta: { requiresAuth: true }
    },
    {
      path: '/settings/plans',
      component: Plans,
      meta: { requiresAuth: true }
    },
    {
      path: '/settings/billing',
      component: Billing,
      meta: { requiresAuth: true }
    },
    {
      path: '/settings/feedback',
      component: Feedback,
      meta: { requiresAuth: true }
    },
    {
      path: '/utility/changelog',
      component: Changelog,
      meta: { requiresAuth: true }
    },
    {
      path: '/utility/roadmap',
      component: Roadmap,
      meta: { requiresAuth: true }
    },
    {
      path: '/utility/faqs',
      component: Faqs,
      meta: { requiresAuth: true }
    },
    {
      path: '/utility/empty-state',
      component: EmptyState,
      meta: { requiresAuth: true }
    },
    {
      path: '/utility/404',
      component: PageNotFound,
      meta: { requiresAuth: true }
    },
    {
      path: '/utility/knowledge-base',
      component: KnowledgeBase,
      meta: { requiresAuth: true }
    },
    {
      path: '/signin',
      component: Signin,
    },
    {
      path: '/signup',
      component: Signup
    },
    {
      path: '/reset-password',
      component: ResetPassword
    },
    {
      path: '/onboarding-01',
      component: Onboarding01,
      meta: { requiresAuth: true }
    },
    {
      path: '/onboarding-02',
      component: Onboarding02,
      meta: { requiresAuth: true }
    },
    {
      path: '/onboarding-03',
      component: Onboarding03,
      meta: { requiresAuth: true }
    },
    {
      path: '/onboarding-04',
      component: Onboarding04,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/button',
      component: ButtonPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/form',
      component: FormPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/dropdown',
      component: DropdownPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/alert',
      component: AlertPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/modal',
      component: ModalPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/pagination',
      component: PaginationPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/tabs',
      component: TabsPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/breadcrumb',
      component: BreadcrumbPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/badge',
      component: BadgePage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/avatar',
      component: AvatarPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/tooltip',
      component: TooltipPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/accordion',
      component: AccordionPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/component/icons',
      component: IconsPage,
      meta: { requiresAuth: true }
    },
    {
      path: '/:pathMatch(.*)*',
      component: PageNotFound
    }
  ]
})

router.beforeEach((to, from, next) => {
  const authStore = useAuthStore();
  const authRequired = to.matched.some(record => record.meta.requiresAuth);
  const userLoggedIn = authStore.isAuthenticated;

  console.log(authRequired);
  console.log(userLoggedIn);
  if (authRequired && !userLoggedIn) {
    next('/signin');
  } else if (to.path === '/signin' && userLoggedIn) {
    next('/');
  } else {
    next();
  }
});

export default router

import { createRouter, createWebHistory } from "vue-router";
import dashboard from "./views/dashboard.vue";
import Signin from "./views/Signin.vue";
import Signup from './views/Signup.vue';
import Admin_dashboard from "./views/admin/admin_dashboard.vue";
import Audit_supplier from './views/admin/audit_supplier.vue';
import Audit_warehouse from './views/admin/audit_warehouse.vue';
import Userinfo_purchaser from './views/admin/userinfo_purchaser.vue';
import Userinfo_warehouse from './views/admin/userinfo_warehouse.vue';
import Userinfo_supplier from './views/admin/userinfo_supplier.vue';
import Admin_analytics from './views/admin/admin_analytics.vue';
import Announcement from "./views/admin/Announcement.vue";
import Admin_account from "./views/admin/admin_account.vue";
import Admin_feedback from "./views/admin/admin_feedback.vue";

const routes = [
    {
        path: '/',
        name: 'home',
        component: Signin,
    },
    {
        path: '/signin',
        name: 'signin',
        component: Signin,
    },
    {
        path: '/signup',
        name: 'signup',
        component: Signup,
    },
    {
        path: '/admin/dashboard/main',
        name: 'admin_dashboard',
        component: Admin_dashboard,
    },
    {
        path: '/admin/audit/supplier',
        name: "audit_supplier",
        component: Audit_supplier,
    },
    {
        path: '/admin/audit/warehouse',
        name: "audit_warehouse",
        component: Audit_warehouse,
    },
    {
        path: '/admin/userinfo/warehouse',
        name: "userinfo_warehouse",
        component: Userinfo_warehouse,
    },
    {
        path: '/admin/userinfo/supplier',
        name: "userinfo_supplier",
        component: Userinfo_supplier,
    },
    {
        path: '/admin/userinfo/purchaser',
        name: "userinfo_purchaser",
        component: Userinfo_purchaser,
    },
    {
        path: '/admin/dashboard/analytics',
        name: "admin_analytics",
        component: Admin_analytics,
    },
    {
        path: '/admin/announcement',
        name: 'admin_announcement',
        component: Announcement,
    },
    {
        path: '/admin/settings/account',
        name: 'admin_account',
        component: Admin_account,
    },
    {
        path: '/admin/settings/feedback',
        name: 'admin_feedback',
        component: Admin_feedback,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
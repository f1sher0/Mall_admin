import { createRouter, createWebHistory } from "vue-router";
import dashboard from "./views/dashboard.vue";
import Signin from "./views/Signin.vue";
import Signup from './views/Signup.vue';
import HighlightText from './views/HighlightText.vue';
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
import Supplier_dashboard from "./views/supplier/supplier_dashboard.vue";
import Supplier_analytics from "./views/supplier/supplier_analytics.vue";
import Supplier_goodslist from "./views/supplier/supplier_goodslist.vue";
import Supplier_newgoods from "./views/supplier/supplier_newgoods.vue";
import Supplier_orderlist from "./views/supplier/supplier_orderlist.vue";
import Supplier_returngoods from "./views/supplier/supplier_returngoods.vue";
import Supplier_shipgoods from "./views/supplier/supplier_shipgoods.vue";
import Supplier_feedback from "./views/supplier/supplier_feedback.vue";
import Supplier_account from "./views/supplier/supplier_account.vue";
import Supplier_announcement from "./views/supplier/supplier_announcement.vue";
import Warehouse_account from "./views/warehouse/warehouse_account.vue";
import Warehouse_analytics from "./views/warehouse/warehouse_analytics.vue";
import Warehouse_announcement from "./views/warehouse/warehouse_announcement.vue";
import Warehouse_dashboard from "./views/warehouse/warehouse_dashboard.vue";
import Warehouse_feedback from "./views/warehouse/warehouse_feedback.vue";
import Warehouse_goodslist from "./views/warehouse/warehouse_goodslist.vue";
import Warehouse_input from "./views/warehouse/warehouse_input.vue";
import Warehouse_output from "./views/warehouse/warehouse_output.vue";
import Purchaser_account from "./views/purchaser/purchaser_account.vue";
import Purchaser_analytics from "./views/purchaser/purchaser_analytics.vue";
import Purchaser_dashboard from "./views/purchaser/purchaser_dashboard.vue";
import Purchaser_feedback from "./views/purchaser/purchaser_feedback.vue";
import Purchaser_orderlist from "./views/purchaser/purchaser_orderlist.vue";
import Purchaser_purchase from "./views/purchaser/purchaser_purchase.vue";
import Purchaser_return from "./views/purchaser/purchaser_return.vue";
import Purchaser_announcement from "./views/purchaser/purchaser_announcement.vue";

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
    {
        path: '/supplier/dashboard/main',
        name: 'supplier_dashboard',
        component: Supplier_dashboard,
    },
    {
        path: '/supplier/dashboard/analytics',
        name: 'supplier_analytics',
        component: Supplier_analytics,
    },
    {
        path: '/supplier/goods/newgoods',
        name: 'supplier_newgoods',
        component: Supplier_newgoods,
    },
    {
        path: '/supplier/goods/goodslist',
        name: 'supplier_goodslist',
        component: Supplier_goodslist,
    },
    {
        path: '/supplier/order/list',
        name: 'supplier_orderlist',
        component: Supplier_orderlist,
    },
    {
        path: '/supplier/order/return',
        name: 'supplier_returngoods',
        component: Supplier_returngoods,
    },
    {
        path: '/supplier/order/ship',
        name: 'supplier_shipgoods',
        component: Supplier_shipgoods,
    },
    {
        path: '/supplier/settings/account',
        name: 'supplier_account',
        component: Supplier_account,
    },
    {
        path: '/supplier/settings/feedback',
        name: 'supplier_feedback',
        component: Supplier_feedback,
    },
    {
        path: '/supplier/announcement',
        name: 'supplier_announcement',
        component: Supplier_announcement,
    },
    {
        path: '/warehouse/dashboard/main',
        name: 'warehouse_main',
        component: Warehouse_dashboard,
    },
    {
        path: '/warehouse/dashboard/analytics',
        name: 'warehouse_analytics',
        component: Warehouse_analytics,
    },
    {
        path: '/warehouse/goods/goodslist',
        name: 'warehouse_goodslist',
        component: Warehouse_goodslist,
    },
    {
        path: '/warehouse/InOut/in',
        name: 'warehouse_input',
        component: Warehouse_input,
    },
    {
        path: '/warehouse/InOut/out',
        name: 'warehouse_output',
        component: Warehouse_output,
    },
    {
        path: '/warehouse/announcement',
        name: 'warehouse_announcement',
        component: Warehouse_announcement,
    },
    {
        path: '/warehouse/settings/account',
        name: 'warehouse_account',
        component: Warehouse_account,
    },
    {
        path: '/warehouse/settings/feedback',
        name: 'warehouse_feedback',
        component: Warehouse_feedback,
    },
    {
        path: '/purchaser/dashboard/main',
        name: 'purchaser_dashboard',
        component: Purchaser_dashboard,
    },
    {
        path: '/purchaser/dashboard/analytics',
        name: 'purchaser_analytics',
        component: Purchaser_analytics,
    },
    {
        path: '/purchaser/purchase/goodslist',
        name: 'purchaser_goodslist',
        component: Purchaser_purchase,
    },
    {
        path: '/purchaser/order/list',
        name: 'purchaser_orderlist',
        component: Purchaser_orderlist,
    },
    {
        path: '/purchaser/order/return',
        name: 'purchaser_return',
        component: Purchaser_return,
    },
    {
        path: '/purchaser/settings/account',
        name: 'purchaser_account',
        component: Purchaser_account,
    },
    {
        path: '/purchaser/settings/feedback',
        name: 'purchaser_feedback',
        component: Purchaser_feedback,
    },
    {
        path: '/purchaser/announcement',
        name: 'purchaser_announcement',
        component: Purchaser_announcement,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
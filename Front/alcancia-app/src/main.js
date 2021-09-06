import { createApp } from "vue";
import App from "./App.vue";
import PrimeVue from "primevue/config";
import Splitter from "primevue/splitter";
import SplitterPanel from "primevue/splitterpanel";
import Panel from "primevue/panel";
import TabView from "primevue/tabview";
import TabPanel from "primevue/tabpanel";
import InputNumber from "primevue/inputnumber";
import Dropdown from "primevue/dropdown";
import Button from "primevue/button";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

import "primevue/resources/primevue.min.css";
import "primevue/resources/themes/bootstrap4-light-blue/theme.css";
import "primeicons/primeicons.css";

const app = createApp(App);

app.use(PrimeVue);

app.component("Panel", Panel);
app.component("Splitter", Splitter);
app.component("SplitterPanel", SplitterPanel);
app.component("TabView", TabView);
app.component("TabPanel", TabPanel);
app.component("InputNumber", InputNumber);
app.component("Dropdown", Dropdown);
app.component("Button", Button);
app.component("DataTable", DataTable);
app.component("Column", Column);
app.mount("#app");

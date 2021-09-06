<template>
  <div class="container">
    <Panel header="Alcancia">
      <TabView>
        <TabPanel header="Añadir">
          <div class="p-field p-col-12 p-md-3">
            <label for="deno" style="margin-right: 10px">Denominacion</label>
            <Dropdown
              v-model="Alcancia.denominacion"
              :options="dataAlcancia"
              optionLabel="denominacion"
              optionValue="denominacion"
              placeholder="Seleccionar Denominacion"
            />
          </div>
          <br />
          <div class="p-field p-col-12 p-md-3">
            <label for="minmax-buttons" style="margin-right: 10px"
              >Cantidad</label
            >
            <InputNumber
              id="minmax-buttons"
              v-model="Alcancia.cantidad"
              mode="decimal"
              showButtons
              :min="1"
              :max="100"
            />
          </div>
          <br />
          <div class="p-field p-col-12 p-md-3">
            <Button label="Agregar" class="p-button-success" @click="agregar" />
          </div>
        </TabPanel>


        <TabPanel header="General">
           <div class="p-d-inline">
                <Dropdown                
                    v-model="filtro3"
                    :options="options"
                    optionLabel="title"
                    optionValue="value"
                    placeholder="Seleccionar Filtro" @change="filtro(3)"
                />
            </div>
            <br><br>
            <div class="p-d-inline" style="width:40%;" v-if="totalDisplay">
                <DataTable
                :value="total"
                stripedRows
                responsiveLayout="scroll"
                > 
                    <Column field="value" :header="this.t"></Column>
                </DataTable>
            </div>
        </TabPanel>


        <TabPanel header="Denominacion">             
            <div class="p-d-inline">
                <Dropdown 
                    v-model="filtro1"
                    :options="dataAlcancia"
                    optionLabel="denominacion"
                    optionValue="denominacion"
                    placeholder="Seleccionar Denominacion"
                />
                <br>
                <br>
                <Dropdown                
                    v-model="filtro2"
                    :options="options"
                    optionLabel="title"
                    optionValue="value"
                    placeholder="Seleccionar Filtro"
                />
                <br><br>
                <div class="p-field p-col-12 p-md-3">
                    <Button label="Filtrar" class="p-button-success" @click="filtro(2)" />
                </div>
            </div>
            <br><br>
            <div class="p-d-inline" style="width:40%;" v-if="display">
                <DataTable
                :value="filtrado"
                stripedRows
                responsiveLayout="scroll"
                >            
                    <Column field="denominacion" header="Denominacion"></Column>
                    <Column field="value" :header="this.title"></Column>
                </DataTable>
            </div>
       </TabPanel>
      </TabView>
    </Panel>
  </div>
</template>

<script>
import AlcanciaService from "../service/Alcancia";

export default {
  data() {
    return {
        totalDisplay:false,
        display: false,
        filtro1:null,
        filtro2:null,
        filtro3:null,
        title:null,
        dataAlcancia: null,
        options:[
            {
                title: "Cantidad",
                value: 0           
            },
            {
                title: "Dinero",
                value: 1            
            },
        ],        
        Alcancia: {
            id: null,
            denominacion: null,
            cantidad: null,
            total: null,
        },
        filtrado: null,
        total: null,
        t:null,
    };
  },
  alcanciaService: null,
  created() {
    this.alcanciaService = new AlcanciaService();
  },
  mounted() {
    this.getAll();
  },
  methods: {
    getAll() {
      this.alcanciaService.getAll().then((data) => {
        this.dataAlcancia = data;
      });
    },
    agregar() {
      const data = this.dataAlcancia.find(d => d.denominacion == this.Alcancia.denominacion);

      this.Alcancia.id = data.id;
      this.alcanciaService.update(this.Alcancia);
      this.getAll();
    },
    filtro(envia){
        if (envia == 3) {
            let suma = 0;
            this.dataAlcancia
            .map(i=> {
                if (this.filtro3 == 0) {
                    suma += i.cantidad;
                    this.t="Cantidad";
                }else{
                    suma += i.total;
                    this.t="Dinero";
                }                
            });
            
            this.total = [
                            { 
                                title: this.t,
                                value: suma,
                            },
                        ];
            this.totalDisplay=true;
            //this.filtro3 = null;
        } else {
            const data = this.dataAlcancia.find(d => d.denominacion == this.filtro1);
            if (this.filtro2 == 0) {    
                this.filtrado = [
                                    { 
                                        denominacion: this.filtro1,
                                        value: data.cantidad,
                                    },
                                ];
                this.title =  "Cantidad";
            } else {
                this.filtrado = [
                                    { 
                                        denominacion: this.filtro1,
                                        value: data.total,
                                    },
                                ];
                this.title = "Dinero";
            }
            this.display = true;
        }
    }
  },
};
</script>

<style scoped>
    .container {
        margin: auto;
        width: 70%;
    }
</style>
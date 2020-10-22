import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { CasilleroService } from './service/CasilleroService';
import {DataTable} from 'primereact/datatable';
import {Column} from 'primereact/column';
import { Panel } from 'primereact/panel';
import { Menubar } from 'primereact/menubar';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { InputNumber } from 'primereact/inputnumber';
import { Button } from 'primereact/button';
import { Toast } from 'primereact/toast';
import { Dropdown } from 'primereact/dropdown';


import 'primereact/resources/themes/saga-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

export default class App extends Component{

  

  constructor(){
    super();
    this.state = {
      visible: false,
      casillero: {
        id: null,
        bloque: null,
        piso: null,
        enPrestamo: false
      },
      selectedCasillero: {},
      prestado: {
        valor: ""
      }
    };

    this.items = [
      {
        label : 'Nuevo',
        icon : 'pi pi-fw pi-plus',
        command : () => {this.showSaveDialog()}
      },
      {
        label : 'Editar',
        icon : 'pi pi-fw pi-pencil',
        command : () => {this.showEditDialog()}
      },
      {
        label : 'Eliminar',
        icon : 'pi pi-fw pi-trash',
        command : () => {this.delete()}
      }
    ];
    this.casilleroService = new CasilleroService();
    this.save = this.save.bind(this);
    this.delete = this.delete.bind(this);
    this.footer=(
      <div>
        <Button label="Guardar" icon="pi pi-check" onClick={this.save} />
      </div>
    );
    
  }

  componentDidMount(){
    this.casilleroService.getAll().then(data => this.setState({casilleros: data}))
    
  }

  
  save(){
    this.casilleroService.save(this.state.casillero).then(data => {
      this.setState({
        visible: false,
        casillero: {
          id: null,
          bloque: null,
          piso: null,
          enPrestamo: false
        }
      });
      this.toast.show({severity: 'success', summary: 'Atención!', detail: 'Se guardó el registro correctamente.'});
      this.casilleroService.getAll().then(data => this.setState({casilleros: data}))
    })
  }

  delete(){
    if(window.confirm("¿Realmente desea eliminar el registro?")){
      this.casilleroService.delete(this.state.selectedCasillero.id).then(data => {
        this.toast.show({severity: 'success', summary: 'Atención!', detail: 'Se eliminó el registro correctamente.'});
        this.casilleroService.getAll().then(data => this.setState({casilleros: data}))
      });
    }
  }


  



  render(){
    return(
      <div style={{width:'90%', margin: '0 auto', marginTop: '20px'}}>
        <Menubar model={this.items}/>
        <br/>
        <Panel header="Casilleros">
          <DataTable  value={this.state.casilleros} paginator={true} rows={5} selectionMode="single" selection={this.state.selectedCasillero} onSelectionChange={e => this.setState({ selectedCasillero: e.value })}>
            <Column field="id" header="ID"></Column>
            <Column field="bloque" header="Bloque"></Column>
            <Column field="piso" header="Piso"></Column>
            <Column field="enPrestamo" header="En Préstamo"></Column>
          </DataTable>
        </Panel>
        <Dialog header="Crear casillero" visible={this.state.visible} style={{ width: '40%' }}  footer={this.footer} modal={true} onHide={() => this.setState({visible: false})}>
          <form id="casillero-form">
            <span className="p-float-label">
              <InputNumber value={this.state.casillero.id} style={{width: '90%'}}  id="id" onChange={(e) => {
                  let val = e.value;
                  this.setState(prevState => {
                    let casillero = Object.assign({}, prevState.casillero)
                    casillero.id = val;
                    
                    return {casillero};
                })}
              } />
              <label htmlFor="id">Identificación</label>
            </span>
            <br/>
            <span className="p-float-label">
              <InputText value={this.state.casillero.bloque} style={{width: '90%'}} id="bloque" onChange={(e) => {
                  let val = e.target.value;
                  this.setState(prevState => {
                    let casillero = Object.assign({}, prevState.casillero)
                    casillero.bloque = val;
                    
                    return {casillero};
                })}
              } />
              <label htmlFor="bloque">Bloque</label>
            </span>
            <br/>
            <span className="p-float-label">
              <InputText value={this.state.casillero.piso} style={{width: '90%'}} id="piso" onChange={(e) => {
                  let val = e.target.value;
                  this.setState(prevState => {
                    let casillero = Object.assign({}, prevState.casillero)
                    casillero.piso = val;
                    
                    return {casillero};
                })}
              } />
              <label htmlFor="piso">Piso</label>
            </span>
            <br/>
            <span className="p-float-label">
              <InputText value={this.state.casillero.enPrestamo} style={{width: '90%'}} id="enPrestamo" onChange={(e) => {
                  let val = e.target.value;
                  this.setState(prevState => {
                    let casillero = Object.assign({}, prevState.casillero)
                    casillero.enPrestamo = val;
                    
                    return {casillero};
                })}
              }/>
              <label htmlFor="enPrestamo">En préstamo</label>
            </span>
          </form>
        </Dialog>
        <Toast ref={(el) => this.toast = el} />
      </div>
      
    );
  }

  showSaveDialog(){
    this.setState({
      visible : true,
      casillero: {
        id: null,
        bloque: null,
        piso: null,
        enPrestamo: false
      }
    });
  }

  showEditDialog(){
    this.setState({
      visible: true,
      casillero: {
        id: this.state.selectedCasillero.id,
        bloque: this.state.selectedCasillero.bloque,
        piso: this.state.selectedCasillero.piso,
        enPrestamo: this.state.selectedCasillero.enPrestamo,
      }
    })
  }

  

}

package edu.ejercicios.ListaDobleEnlace;

public class ListaDoble {
    private Nodo inicio;
    private Nodo fin;
    private int cantidadDatos;
    public ListaDoble()
    {
        this.inicio=null;
        this.fin=null;
        this.cantidadDatos=0;
    }

    public boolean estaVacia() {return inicio==null & fin==null;}

    public void agregarInicio(Object dato)
    {
        if (estaVacia()) //verificamos si es una lista vacia, entonces el dato ingresado sera el unico
        {
            inicio=fin=new Nodo(dato,null, null);
        }
        else
        {
            Nodo nuevo = new Nodo(dato, inicio, null); //creamos el nuevo nodo y decimos que el siguiente sera el inicio y anterior null
            inicio.setAnterior(nuevo);  //indicamos que el inicio tendra como enlace anterior el nuevo
            inicio=nuevo; //hacemos que el nuevo sea el primero
        }
        cantidadDatos++;
    }

    public void agregarAlFinal(Object dato)
    {
        if (estaVacia())
        {
            inicio=fin=new Nodo(dato,null, null);
        }
        else
        {
            Nodo nuevo = new Nodo(dato, null, fin);  //se crea el nuevo, y decimos que el enlace siguiente es null y el anterior seria el nodo fin
            fin.setSiguiente(nuevo);  //decimos que el enlace siguiente del fin sera el nuevo
            fin=nuevo; //y ahora el nuevo es el fin
        }
        cantidadDatos++;
    }

    public String mostarListaInicio()
    {
        String salida= "";
        if (!estaVacia())
        {
            Nodo aux;  //creamos nodo aux para recorrer la lista
            aux=inicio;
            while(aux!=null) //nos recorrera mientras que aux no sea el ultimo
            {
                salida+=aux.getDato() + " "; //nos mostrara el dato del aux
                aux=aux.getSiguiente(); //el aux ira saltando de posicion
            }
        }
        return salida;
    }

    public String mostrarListaFin()
    {
        String salida= "";
        if (!estaVacia())
        {
            Nodo aux; //creamos nodo aux para recorrer la lista
            aux=fin; //en este caso al ser de derecha a izquierda, iniciamos el aux desde el fin
            while(aux!=null) //nos recorrera mientras que aux no sea el ultimo
            {
                salida+=aux.getDato() + " "; //nos mostrara el dato del aux
                aux=aux.getAnterior(); //el aux ira saltando de posicion pero de reversa
            }
        }
        return salida;
    }

    public void eliminarInicio()
    {
        if(!estaVacia())
        {
            if(inicio==fin)
            {
                inicio= fin = null;  //caso en el que solo hay un dato, entonces inicio y fin sera null y es eliminado
            }
            else
            {
                inicio= inicio.getSiguiente(); //decimos que el inicio pasara a ser al siguiente del inicio (en ese mometo)
                inicio.setAnterior(null); //ahora inicio ya cambio, y decimos que lo anterior es null, por lo tanto se elimino
            }
            cantidadDatos--;
        }
    }

    public void eliminarAlFinal()
    {
        if(!estaVacia())
        {
            if(inicio==fin)
            {
                inicio= fin = null;
            }
            else
            {
              fin= fin.getAnterior(); //decimos que el fin pasara a ser el anterior del fin (actual)
              fin.setSiguiente(null); //decimos que fin ya cambiando, su enlace siguiente sera nulo, por lo tanto se elimino el ultimo dato
            }
            cantidadDatos--;
        }
    }

    public void eliminarRepetidos() {
        if (estaVacia() || cantidadDatos == 1)
        {
            System.out.println("Lista Vacia o Lista De Un Solo Dato");
            return;
        }
        Nodo aux;
        aux=inicio;
        while (aux != null) {
            Nodo comparador;
            comparador=aux;
            while (comparador.getSiguiente() != null)   // recorrera los nodos siguientes al auxiliar
            {
                if (comparador.getSiguiente().getDato() == aux.getDato()) { // al tener el nodo auxiliar y el comparador, si estos en algun momento son iguales
                    comparador.setSiguiente(comparador.getSiguiente().getSiguiente());  //se eliminara uno
                    cantidadDatos--;
                } else {
                    comparador = comparador.getSiguiente();
                }
            }
            aux = aux.getSiguiente();
        }
    }

    public void agregarEnMedio(Object dato)
    {
        if (estaVacia()) {
            agregarInicio(dato); // Se verifica si esta vacia, si lo esta solo agregamos al inicio
            return;
        }
        Nodo nuevo = new Nodo(dato, null, null);
        Nodo bucsB = inicio;   //se crean 2 nodos, que nos recorreran la lista, uno lo hara un paso por delante del otro
        Nodo ninjaT = inicio.getSiguiente();  //se inicia desde el 2do nodo
        while (ninjaT != null && ninjaT.getSiguiente() != null)  // aca indicamos que el nodo ninjaT avance un paso por delante de bucsB
        {
            bucsB = bucsB.getSiguiente();
            ninjaT = ninjaT.getSiguiente().getSiguiente();
        }
        nuevo.setSiguiente(bucsB.getSiguiente()); // se insertara el nuevo nodo delante del nodo bucsB
        if (bucsB.getSiguiente() != null) { //verificamos que el nodo bucsB no sea el ultimo y asi insertamos el nuevo entre 2 existentes
            bucsB.getSiguiente().setAnterior(nuevo);
        }
        nuevo.setAnterior(bucsB); //E indicamos el enlace anterior el cual sera el nodo bucsB
        bucsB.setSiguiente(nuevo); //y bucsB apunta al nuevo nodo ingresado
        cantidadDatos++;

    }

    public void eliminarEnMedio(){
        Nodo aux = inicio; //hacemos uso del nodo auxiliar para recorrer la lista
        Nodo anterior = null;
        while (aux != null)
        {
            if (aux.getDato().equals(1)) {
                if (anterior != null)
                    anterior.setSiguiente(aux.getSiguiente());
            }
            if (aux.getSiguiente() != null){
                aux.getSiguiente().setAnterior(anterior);
            }
            anterior = aux;
            aux = aux.getSiguiente();
        }
        cantidadDatos--;
    }

    public Nodo getInicio() {
        return inicio;
    }
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }
    public Nodo getFin() {
        return fin;
    }
    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    public int getCantidadDatos() {
        return cantidadDatos;
    }
    public void setCantidadDatos(int cantidadDatos) {
        this.cantidadDatos = cantidadDatos;
    }
}
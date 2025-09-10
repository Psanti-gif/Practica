import java.util.Scanner;
import java.util.Stack;

public class practica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<PaginaWeb> historial = new Stack<>();
        int opcion = -1;

        while(opcion !=0){
            System.out.println("\n-------MENU NAVEGADOR-------");
            System.out.println("1. Visitar una página nueva");
            System.out.println("2. Retroceder");
            System.out.println("3. Ver Historial");
            System.out.println("0. Salir");
            System.out.println("Ingrese Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                
                case 1:
                    PaginaWeb nuevaPagina = new PaginaWeb();
                    System.out.println("Ingrese URL:");
                    nuevaPagina.setUrl(sc.nextLine());
                    System.out.println("Ingrese titulo: ");
                    nuevaPagina.setTitulo(sc.nextLine());
                    System.out.println("Ingrese fecha de acceso: ");
                    nuevaPagina.setFechaAcceso(sc.nextLine());

                    historial.push(nuevaPagina);
                    System.out.println("Página agregada al historial.");
                    break;
                case 2:
                    if(!historial.isEmpty()){
                        PaginaWeb ultima = historial.pop();
                        System.out.println("Retrocediendo... cerrando: "+ ultima.getTitulo());
                        if(!historial.isEmpty()){
                            System.out.println("Ahora estas en: "+ historial.peek().getTitulo());

                        }else{
                            System.out.println("No hay páginas en el historial.");
                        }

                    }else{
                        System.out.println("El historial esta vacio");
                    }
                    break;

                case 3:
                    if(historial.isEmpty()){
                        System.out.println("El historial esta vacio");
                    }else{
                        System.out.println("\n----HISTORIAL----");
                        for (int i = historial.size() - 1; i >= 0; i--) {
                            PaginaWeb p = historial.get(i);
                            System.out.println("Titulo: " + p.getTitulo());
                            System.out.println("URL: " +p.getUrl());
                            System.out.println("Fecha: "+ p.getFechaAcceso());
                        }
                    }
                    break;
                case 0: 
                    System.out.println("Saliendo del navegador...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
       String menu= """
               **************CONVERSOR DE DIVISAS**************
               1) Dólares Americanos a Pesos Mexicanos
               2) Pesos Mexicanos a Dólares Americanos
               3) Dólares Americanos a Pesos Argentinos
               4) Pesos Argentinos a Dólares Americanos
               5) Dólares Americanos a Yenes Japoneses
               6) Yenes Japoneses a Dólares Americanos
               7) Salir
               ************************************************
               Por favor ingrese una opción válida:
               """;
        int opcionMenu=0;
        double cantidad=0;
        Scanner inputUsuario=new Scanner(System.in);
        ConsultaDivisa consulta=new ConsultaDivisa();
       while (opcionMenu!=7){
           System.out.println(menu);
           opcionMenu=Integer.parseInt(inputUsuario.nextLine());
           if (opcionMenu==7){
               break;
           } else if (opcionMenu<1||opcionMenu>7) {
               System.out.println("Opcion invalida");
               break;
           }
           System.out.println("Ingresa la cantidad que quieres convertir:");
           cantidad=Double.parseDouble(inputUsuario.nextLine());
           Divisa divisa=consulta.buscarDivisa(opcionMenu,cantidad);
           System.out.println(divisa);
       };
        System.out.println("PROGRAMA TERMINADO");
    }
}

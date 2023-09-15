import java.util.*;

/*
La expansión desmedida de terrenos para ejercer la ganadería ejerce un aumento en las tasas de deforestación.
El siguiente programa pretende llevar un control sobre el aumento de las hectáreas que pertenecen a personas que
ejercen la ganadería.

- Tenemos un arreglo con datos del 2018 y un arreglo con datos del 2023.
- Un método llamado compararAnhos() que compara los datos de ambos arreglos y guarda en 1 ArrayList para indagar
  a las personas que aumentaron sus hectáreas y en otro ArrayList a las que no.
- Un método aumento(String id) que recibe la ID del propietario y busca en el arreglo del 2018 y del 2023 la cantidad de
  hectáreas y calcula cuánto aumentó para posteriormente retornarlo.
- Un método parajustificarAumento() que arroja los datos de los propietarios cuya cantidad de hectáreas aumentó.
- Un método multaPorAumento(Integer n) que calcula el valor de la multa teniendo como base que por 1 héctarea son
  $40,000,000 de multa.
- Un método origenValido() que tiene como finalidad que si el propietario muesra un origen valido del aumento, se
  elimina del ArrayList para indagar a las personas que aumentaron sus hectáreas y se agrega al ArrayList de las personas
  a no indagar.
- Un método analizarDatos() que tiene como finalidad mostrar la cantidad de personas por municipio que aumentaron sus
  hectáreas.
- Un método menu() que controla la ejecución del programa.
*/
public class Main {

    public record datosPropietario(String id, String nombre, String municipio, Integer numHectareas, Integer numBovinos,
                                   Integer anho) {
    }

    private static List<datosPropietario> propietarioNoIndagar = new ArrayList<>();
    private static List<datosPropietario> propietarioIndagar = new ArrayList<>();
    private static datosPropietario[] datos2018 = new datosPropietario[10];
    private static datosPropietario[] datos2023 = new datosPropietario[10];
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {



        //DATOS AÑO 2018

        datos2018[0] = new datosPropietario("87845488", "Juan Ignacio Lloreda", "Andes",
                25, 70, 2018);
        datos2018[1] = new datosPropietario("5964574", "María del Pilar Rodriguez", "Jericó",
                5, 15, 2018);
        datos2018[2] = new datosPropietario("254987", "Jorge Andrés Tirado", "Amalfi",
                85, 100, 2018);
        datos2018[3] = new datosPropietario("88945488", "Juan Pablo Ramiréz", "Amagá",
                55, 120, 2018);
        datos2018[4] = new datosPropietario("596784574", "Juana Paula Rodriguez", "Jericó",
                50, 95, 2018);
        datos2018[5] = new datosPropietario("145254987", "Hugo Linares Mesa", "Amalfi",
                185, 1000, 2018);
        datos2018[6] = new datosPropietario("548703255", "Pedro Pablo Restrepo", "Andes",
                15, 40, 2018);
        datos2018[7] = new datosPropietario("8795964574", "Camila Noriz Muñoz", "Fredonia",
                45, 165, 2018);
        datos2018[8] = new datosPropietario("45254987", "Felipe Rubio Tirado", "Betania",
                10, 28, 2018);
        datos2018[9] = new datosPropietario("436254987", "Paola Angarita Garay", "Betania",
                3, 10, 2018);

        //DATOS AÑO 2023

        datos2023[0] = new datosPropietario("87845488", "Juan Ignacio Lloreda", "Andes",
                25, 70, 2018);
        datos2023[1] = new datosPropietario("5964574", "María del Pilar Rodriguez", "Jericó",
                5, 15, 2018);
        datos2023[2] = new datosPropietario("254987", "Jorge Andrés Tirado", "Amalfi",
                88, 100, 2018);
        datos2023[3] = new datosPropietario("88945488", "Juan Pablo Ramiréz", "Amagá",
                55, 120, 2018);
        datos2023[4] = new datosPropietario("596784574", "Juana Paula Rodriguez", "Jericó",
                57, 95, 2018);
        datos2023[5] = new datosPropietario("145254987", "Hugo Linares Mesa", "Amalfi",
                188, 1000, 2018);
        datos2023[6] = new datosPropietario("548703255", "Pedro Pablo Restrepo", "Andes",
                16, 40, 2018);
        datos2023[7] = new datosPropietario("8795964574", "Camila Noriz Muñoz", "Fredonia",
                45, 165, 2018);
        datos2023[8] = new datosPropietario("45254987", "Felipe Rubio Tirado", "Betania",
                10, 28, 2018);
        datos2023[9] = new datosPropietario("436254987", "Paola Angarita Garay", "Betania",
                4, 10, 2018);

        menu();


    }

    public static void compararAnhos() {
        for (int ianhos = 0; ianhos < datos2018.length; ianhos++) {
            if (datos2018[ianhos].numHectareas < datos2023[ianhos].numHectareas) {
                propietarioIndagar.add(datos2023[ianhos]);
            } else {
                propietarioNoIndagar.add(datos2023[ianhos]);
            }
        }
        System.out.println("Se han comparado los registros del año 2023 con los del año 2018");
        System.out.println(" ");
    }

    public static Integer aumento(String id) {
        Integer aument = null;
        for (datosPropietario d18 : datos2018) {
            if (Objects.equals(d18.id, id)) {
                for (datosPropietario d23 : datos2023) {
                    if (Objects.equals(d23.id, id)) {
                        aument = d23.numHectareas - d18.numHectareas;
                    }
                }
            }
        }
        return aument;
    }


    public static void parajustificarAumento() {
        for (datosPropietario datosP : propietarioIndagar) {
            System.out.println("NOMBRE: " + datosP.nombre + "\nIDENTIFICACIÓN: " + datosP.id + "\nMUNICIPIO: " + datosP.municipio +
                    "\n-----> AUMENTÓ: " + aumento(datosP.id) + " HECTAREAS");
            System.out.println("---------------");
        }
    }

    public static void multaPorAumento(Integer n) {
        System.out.println("La multa es de: $" + n * 40000000);
        System.out.println("------------------------");
    }

    public static void origenValido() {
        String ident;
        System.out.print("Ingrese ID del propietario: ");
        ident = scan.next();
        for (datosPropietario d : propietarioIndagar) {
            if (Objects.equals(d.id, ident)) {
                propietarioNoIndagar.add(d);
                propietarioIndagar.remove(d);
                System.out.println("El propietario con identificación: " + d.id + " se agregó a propietarios" +
                        " para no indagar y se removió de los propietarios para no indagar.");
                multaPorAumento(0);
                break;
            }
        }
    }


    public static void analizarDatos() {
        List<String> municipios = new ArrayList<>();
        for (datosPropietario propietario : propietarioIndagar) {
            municipios.add(propietario.municipio());
        }
        Set<String> filtrar = new HashSet<>(municipios);
        for (String f : filtrar) {
            System.out.println("En el municipio " + f + " hay " + Collections.frequency(municipios, f) + " propietarios" +
                    "con aumento de hectareas.");
        }
        System.out.println(" ");
    }

    public static void menu() {
        int opc;
        System.out.println("1.Iniciar." +
                "\n2.Analizar datos actuales.");
        System.out.println("Digite la opción: ");
        opc = scan.nextInt();
        switch (opc) {
            case 1:
                compararAnhos();
                break;
            case 2:
                parajustificarAumento();
                break;
        }
        do {
            System.out.println("1.Gestionar aumento de héctareas." +
                    "\n2.Validar origen de aumento." + "\n3.Analizar datos actuales." + "\n4.Salir");
            System.out.println("Digite la opción: ");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    parajustificarAumento();
                    break;
                case 2:
                    origenValido();
                    break;
                case 3:
                    analizarDatos();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (opc != 1 || opc != 2 || opc != 3 || opc != 4);
    }


}





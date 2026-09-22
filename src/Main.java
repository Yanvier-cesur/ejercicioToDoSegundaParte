import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static ArrayList<Tarea> tareas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu(){

        System.out.println("--------GESTOR DE TAREAS MIXTOL-------");
        System.out.println("1. Añadir tareas");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Marcar tarea completada");
        System.out.println("4. Tareas pendientes");
        System.out.println("5. Borrar tarea");
        System.out.println("6. Salir");

    }
    static void main() {

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> añadirTareas();
                case "2" -> mostrarTareas();
                case "3" -> marcarCompletada();
                case "4" -> tareasPendientes();
                case "5" -> borrarTarea();
                case "6" -> {
                    salir = true;
                    System.out.println("Saliendo de la aplicación...");
                }
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.\n");
            }
        }


    }

    public static void añadirTareas(){
        System.out.print("Escribe la descripción de la tarea: ");
        String descripcion = scanner.nextLine();

        System.out.print("Escribe la prioridad de la tarea (alta,media o baja): ");
        String prioridad = scanner.nextLine();

        Tarea nueva = new Tarea(descripcion,false,prioridad);
        tareas.add(nueva);

        System.out.println("Tarea añadida con ID " + nueva.getID() + "\n");
    }

    public static void mostrarTareas(){
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas todavía.\n");
            return;
        }
        System.out.println("Filtrar tareas por prioridad?: ");
        String filtrar = scanner.nextLine();
        if (filtrar.equals("no")) {
            for (Tarea t : tareas) {
                System.out.println(t);
            }
            System.out.println();
        } else if (filtrar.equals("si")) {
            tareas.sort(Comparator.comparingInt(t -> {
                switch (t.getPrioridad().toLowerCase()) {
                    case "alta": return 1;
                    case "media": return 2;
                    case "baja": return 3;
                    default: return 4;
                }
            }));

            for (Tarea t : tareas) {
                System.out.println(t);
            }
            System.out.println();
        }
    }

    public static void marcarCompletada(){
        mostrarTareas();
        System.out.print("Introduce el ID de la tarea a marcar como completada: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Tarea t : tareas) {
            if (t.getID() == id) {
                t.marcarCompletada();
                System.out.println("Tarea marcada como completada.\n");
                return;
            }
        }
        System.out.println("No se ha encontrado ninguna tarea con ese ID.\n");
    }

    public static void tareasPendientes(){
        boolean hayPendientes = false;

        for (Tarea t : tareas) {
            if (!t.isCompletada()) {
                System.out.println(t);
                hayPendientes = true;
            }
        }

        if (!hayPendientes) {
            System.out.println("No hay tareas pendientes.");
        }
        System.out.println();
    }

    public static void borrarTarea(){
        mostrarTareas();
        System.out.print("Introduce el ID de la tarea a borrar: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getID() == id) {
                tareas.remove(i);
                System.out.println("Tarea borrada.\n");
                return;
            }
        }
        System.out.println("No se ha encontrado ninguna tarea con ese ID.\n");
    }
}

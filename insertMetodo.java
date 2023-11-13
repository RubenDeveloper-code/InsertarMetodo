class insertMetodo {
    static final int NOMBRE = 0;
    static final int NCONTROL = 1;
    static final int CALIFICACION = 2;
    static final int CARRERA = 3;

    public static void main(String main[]) {
        Alumno[] alumnos = new Alumno[10];
        alumnos[0] = new Alumno("Francisco", 123456, 90, "ISC");
        alumnos[1] = new Alumno("Mujica", 251917, 100, "Economia");
        alumnos[2] = new Alumno("Alvaro", 1121920, 80, "Derecho");
        alumnos[3] = new Alumno("Josefa", 131415, 70, "DG");
        alumnos[4] = new Alumno("Plutarco", 666, 66, "Teologia");
        alumnos[5] = new Alumno("Jose", 1111111, 90, "IngCivil");
        alumnos[6] = new Alumno("Gustavo", 111300, 92, "Psicologia");
        alumnos[7] = new Alumno("Ernesto", 25000000, 70, "Macro Economia");
        alumnos[8] = new Alumno("Enrique", 20120043, 27, "Fisica Cuantica");
        alumnos[9] = new Alumno("Elena", 0101010, 90, "Fisica");

        System.out.println("\nNombre");
        IncersionMetodoPorCampo(alumnos, NOMBRE, false);
        printArray(alumnos);
        System.out.println("\nNControl");
        IncersionMetodoPorCampo(alumnos, NCONTROL, false);
        printArray(alumnos);
        System.out.println("\nCalificacion");
        IncersionMetodoPorCampo(alumnos, CALIFICACION, false);
        printArray(alumnos);
        System.out.println("\nCarrera");
        IncersionMetodoPorCampo(alumnos, CARRERA, false);
        printArray(alumnos);

        System.out.println("\nNombre Inverso");
        IncersionMetodoPorCampo(alumnos, NOMBRE, true);
        printArray(alumnos);
        System.out.println("\nNControl Inverso");
        IncersionMetodoPorCampo(alumnos, NCONTROL, true);
        printArray(alumnos);
        System.out.println("\nCalificacion Inverso");
        IncersionMetodoPorCampo(alumnos, CALIFICACION, true);
        printArray(alumnos);
        System.out.println("\nCarrera Inverso");
        IncersionMetodoPorCampo(alumnos, CARRERA, true);
        printArray(alumnos);
    }

    public static void IncersionMetodoPorCampo(Alumno []array,int campo, boolean inverso) {
        int i, k, n_elementos = array.length;
        Alumno aux;
        for(i=1; i<n_elementos; i++)
        {
            aux= array[i];
            k= (i-1);

            while(k>=0 && comparator(array, k,aux, campo, inverso))
            {
                array[k+1]=array[k];
                k--;
            }
            array[k+1]=aux;
        }
    }

    public static boolean comparator(Alumno alumnos[], int k, Alumno aux, int field,boolean inverse) {
        boolean resEval = false;
        switch(field) {
        case NOMBRE:
            resEval = alumnos[k].getNombre().compareTo(aux.getNombre())>0;
            break;
        case CARRERA:
            resEval = alumnos[k].getCarrera().compareTo(aux.getCarrera())>0;
            break;
        case NCONTROL:
            resEval = alumnos[k].getNControl() > aux.getNControl();
            break;
        case CALIFICACION:
            resEval = alumnos[k].getCalificacion() > aux.getCalificacion();
            break;
        }
        return inverse? !resEval : resEval;
    }

    public static void printArray(Alumno[] objs) {
        for(Alumno obj:objs ) {
            System.out.println(obj.toString());
        }
    }

}

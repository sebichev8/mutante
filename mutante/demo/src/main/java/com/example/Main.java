package com.example;

public class Main {
    public static void main(String[] args) {

        String[] dna123 = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG" };

        String[] dna1234 = {
                "CCCCTA",
                "AGCTAG",
                "TACCAG",
                "ATGACA",
                "ATASFG",
                "ASDASD" };

        String[] dna12345= {
                "ATGCGA",
                "CAGTGC",
                "TTGTGT",
                "AGAATG",
                "CCGCTA",
                "TCACTG"};

        String[] dna = {
                "CCCCTA",
                "AGCTAG",
                "TATTCG",
                "ATTACA",
                "ATASFG",
                "ASDASD" };






        // Crea un array bidimensional de caracteres y los almacena (de cada palabra de
        // dna)
        char[][] dnaMatrix = new char[dna.length][];

        // itera sobre cada palabra de dna y la convierte a cada palabra en un array de
        // caracteres
        for (int i = 0; i < dna.length; i++) {
            dnaMatrix[i] = dna[i].toCharArray();
        }




        //TRY CATCH PARA AGARRAR ERRORES
        try {
            //SI LA SUMA DE CADA FUNCION ES 2 O MAS GENES ES MUTANTE EL INDIVIDUO
            if (VerificacionHorizontal(dnaMatrix)+VerificacionVertical(dnaMatrix)+VerificarDiagonales(dnaMatrix)+VerificarDiagonalesInvertidas(dnaMatrix)>=2){
                System.out.println("ES MUTANTE");
            }else{
                //SI NO ES EL CASO, LA PERSONA TIENE MENOS DE 2 GENES, NO ES MUTANTE
                System.out.println("NO ES MUTANTE");
            }
            //PARA MOSTRAR ERROR
        }catch (Exception e){
            System.out.printf("ERROR  "+ e.getMessage());
        }
    }




    public static int VerificacionHorizontal(char[][] entrada) {
        int mutante = 0;

        for (int i = 0; i < entrada.length; i++) {
            int aux = 1;
            for (int j = 0; j < entrada[i].length - 1; j++) {
                if (entrada[i][j] == entrada[i][j + 1]) {
                    aux++;
                    if (aux > 3 ) { // Si encontramos 4 o más caracteres consecutivos iguales
                        mutante++;
                    }
                } else {
                    aux = 1; // Reiniciamos aux si los caracteres no son iguales
                }
            }
        }
        return mutante;
    }

    public static int VerificacionVertical(char[][] entrada) {
        int mutante = 0;
        int n = entrada.length;
        int m = entrada[0].length;

        for (int j = 0; j < m; j++) {
            int aux = 1;
            for (int i = 0; i < n - 1; i++) {
                if (entrada[i][j] == entrada[i + 1][j]) {
                    aux++;
                    if (aux == 4) {
                        mutante++;
                        break; // Si ya hay 4 caracteres iguales, no es necesario seguir verificando esta columna
                    }
                } else {
                    aux = 1;
                }
            }
        }
        return mutante;
    }

    public static int VerificarDiagonales(char[][] dnaMatrix) {
        int contadorDiagonalPrincipal = 1;
        int contadorDiagonalSecundaria = 1;
        int mutante = 0;
        for (int i = 0; i < dnaMatrix.length - 1; i++) {
            // Verificación de la diagonal principal
            if (i + 1 < dnaMatrix.length) {
                if (dnaMatrix[i][i] == dnaMatrix[i + 1][i + 1]) {
                    contadorDiagonalPrincipal++;
                    if (contadorDiagonalPrincipal == 4) {
                        mutante++;
                    }
                } else {
                    contadorDiagonalPrincipal = 1; // Reiniciar el contador si los caracteres no son iguales.
                }
            }

            // Verificación de la diagonal secundaria DERECHA DE [i][i + 1] OSEA 0+1
            if (i + 1 < dnaMatrix.length-1) {
                if (dnaMatrix[i][i + 1] == dnaMatrix[i + 1][i + 2]) {
                    contadorDiagonalSecundaria++;
                    if (contadorDiagonalSecundaria == 4) {
                        mutante++;
                    }
                } else {
                    contadorDiagonalSecundaria = 1; // Reiniciar el contador si los caracteres no son iguales.
                }
            }

            // Verificación de la diagonal secundaria HACIA LA IZQUIERDA
            if (i + 1 < dnaMatrix.length-1) {
                if (dnaMatrix[i+1][i] == dnaMatrix[i + 2][i + 1]) {
                    contadorDiagonalSecundaria++;
                    if (contadorDiagonalSecundaria == 4) {
                        mutante++;
                    }
                } else {
                    contadorDiagonalSecundaria = 1; // Reiniciar el contador si los caracteres no son iguales.
                }
            }

        }
        return mutante; // Devuelve el valor de mutante.
    }

    public static int VerificarDiagonalesInvertidas(char[][] dnaMatrix) {
        int contadorDiagonalPrincipal = 1;
        int contadorDiagonalSecundaria = 1;
        int mutante = 0;
            // Verificación de la diagonal principal invertida
            int contadorDiagonalPrincipalInversa = 1;
            for (int i = 1; i < dnaMatrix.length; i++) {
                if (dnaMatrix[dnaMatrix.length - i - 1][i] == dnaMatrix[dnaMatrix.length - i][i - 1]) {
                    contadorDiagonalPrincipalInversa++;
                    if (contadorDiagonalPrincipalInversa == 4) {
                        mutante++;
                    }
                } else {
                    contadorDiagonalPrincipalInversa = 1; // Reiniciar el contador si los caracteres no son iguales.
                }
            }

            // Verificación de la diagonal secundaria invertida hacia la IZQUIERDA
            int contadorDiagonalSecundariaInversaIzquierda = 1;
            for (int i = 1; i < dnaMatrix.length - 1; i++) {
                if (dnaMatrix[i][dnaMatrix.length - i - 2] == dnaMatrix[i - 1][dnaMatrix.length - i - 1]) {
                    contadorDiagonalSecundariaInversaIzquierda++;
                    if (contadorDiagonalSecundariaInversaIzquierda == 4) {
                        mutante++;
                    }
                } else {
                    contadorDiagonalSecundariaInversaIzquierda = 1; // Reiniciar el contador si los caracteres no son iguales.
                }
            }

            // Verificación de la diagonal secundaria invertida hacia la DERECHA
            int contadorDiagonalSecundariaInversaDerecha = 1;
            for (int i = 1; i < dnaMatrix.length - 1; i++) {
                if (dnaMatrix[dnaMatrix.length - i - 2][dnaMatrix.length - i - 1] == dnaMatrix[dnaMatrix.length - i - 1][dnaMatrix.length - i]) {
                    contadorDiagonalSecundariaInversaDerecha++;
                    if (contadorDiagonalSecundariaInversaDerecha == 4) {
                        mutante++;
                    }
                } else {
                    contadorDiagonalSecundariaInversaDerecha = 1; // Reiniciar el contador si los caracteres no son iguales.
                }
            }
        return mutante; // Devuelve el valor de mutante.
    }

}
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // membaca file
    boolean file_exist = true;
    System.out.print("Masukkan nama file: ");
    String filename = scanner.next();
    Scanner reader;
    ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>();
    try {
      reader = new Scanner(new File(filename));
      boolean isword = false;
      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        if (!isword) { // membaca matrix huruf
          if (line.length() != 0) {
            ArrayList<String> row = new ArrayList<String>();
            for (int i = 0; i < line.length(); i++) {
              if (line.charAt(i) != ' ') {
                String a = String.valueOf(line.charAt(i));
                row.add(a);
              }
            }
            matrix.add(row);
          } else {
            isword = true;
          }
        } else { // membaca daftar kata yang dicari
          ArrayList<String> word = new ArrayList<String>();
          for (int i = 0; i < line.length(); i++) {
            String a = String.valueOf(line.charAt(i));
            word.add(a);
          }
          words.add(word);
        }
      }
      reader.close();
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("File " + filename + " tidak ditemukan");
      file_exist = false;
    }

    // Proses mencari kata dalam puzzle
    if (file_exist) {
      long total_time = 0;
      int perbandingan_total = 0;
      int banyak_kata = words.size();
      int count = 0;
      int nrow_mat = matrix.size();
      int ncol_mat = matrix.get(0).size();
      
      while (count < banyak_kata) { 
        boolean found = false, kanan = false, kiri = false, bawah = false, atas = false, kanan_bawah = false, kiri_atas = false, kiri_bawah = false, kanan_atas = false;
        int idx = 0, i = 0, j = 0, perbandingan = 0;;
        int len = (words.get(count)).size();
        long start_time = System.nanoTime();
        
        // pencarian dengan arah ke kanan
        while (!found) {
          if (j <= ncol_mat - len) {
            while (idx < len) {
              String char_matrix = matrix.get(i).get(j+idx);
              String char_word = words.get(count).get(idx);
              perbandingan++;
              if (char_matrix.equals(char_word)) {
                idx++;
              } else {
                j++;
                idx = 0;
                break;
              }
            }
          } else {
            if (i < nrow_mat - 1) {
              i++;
              j = 0;
            } else {
              break;
            }
          }
          if (len == idx) {
            found = true;
            kanan = true;
            count++;
          }
        }

        // pencarian dengan arah ke kiri
        if (!found) {
          idx = 0; i = 0; j = ncol_mat - 1;
        }
        while (!found) {
          if (j >= len - 1) {
            while (idx < len) {
              String char_matrix = matrix.get(i).get(j-idx);
              String char_word = words.get(count).get(idx);
              perbandingan++;
              if (char_matrix.equals(char_word)) {
                idx++;
              } else {
                j--;
                idx = 0;
                break;
              }
            }
          } else {
            if (i < nrow_mat - 1) {
              i++;
              j = ncol_mat - 1;
            } else {
              break;
            }
          }
          if (len == idx) {
            found = true;
            kiri = true;
            count++;
          }
        }

        // pencarian dengan arah ke bawah
        if (!found) {
          idx = 0; i = 0; j = 0;
        }
        while (!found) {
          if (i <= nrow_mat - len) {
            while (idx < len) {
              String char_matrix = matrix.get(i+idx).get(j);
              String char_word = words.get(count).get(idx);
              perbandingan++;
              if (char_matrix.equals(char_word)) {
                idx++;
              } else {
                i++;
                idx = 0;
                break;
              }
            }
          } else {
            if (j < ncol_mat - 1) {
              j++;
              i = 0;
            } else {
              break;
            }
          }
          if (len == idx) {
            found = true;
            bawah = true;
            count++;
          }
        }

        // pencarian dengan arah ke atas
        if (!found) {
          idx = 0; i = nrow_mat - 1; j = 0;
        }
        while (!found) {
          if (i >= len - 1) {
            while (idx < len) {
              String char_matrix = matrix.get(i-idx).get(j);
              String char_word = words.get(count).get(idx);
              perbandingan++;
              if (char_matrix.equals(char_word)) {
                idx++;
              } else {
                i--;
                idx = 0;
                break;
              }
            }
          } else {
            if (j < ncol_mat - 1) {
              j++;
              i = nrow_mat - 1;
            } else {
              break;
            }
          }
          if (len == idx) {
            found = true;
            atas = true;
            count++;
          }
        }

        // pencarian dengan arah ke kanan bawah
        if (!found) {
          idx = 0; i = 0; j = 0;
        }
        while (!found) {
          if (j <= ncol_mat - len) {
            while (idx < len) {
              String char_matrix = matrix.get(i+idx).get(j+idx);
              String char_word = words.get(count).get(idx);
              perbandingan++;
              if (char_matrix.equals(char_word)) {
                idx++;
              } else {
                j++;
                idx = 0;
                break;
              }
            }
          } else {
            if (i < nrow_mat - len) {
              i++;
              j = 0;
            } else {
              break;
            }
          }
          if (len == idx) {
            found = true;
            kanan_bawah = true;
            count++;
          }
        }

        // pencarian dengan arah ke kiri atas
        if (!found) {
          idx = 0; i = nrow_mat - 1; j = ncol_mat - 1;
        }
        while (!found) {
          if (j >= len - 1) {
            while (idx < len) { 
              String char_matrix = matrix.get(i-idx).get(j-idx);
              String char_word = words.get(count).get(idx);
              perbandingan++;
              if (char_matrix.equals(char_word)) {
                idx++;
              } else {
                j--;
                idx = 0;
                break;
              }
            }
          } else {
            if (i >= len) {
              i--;
              j = ncol_mat - 1;
            } else {
              break;
            }
          }
          if (len == idx) {
            found = true;
            kiri_atas = true;
            count++;
          }
        }

        // pencarian dengan arah ke kiri bawah
        if (!found) {
          idx = 0; i = 0; j = ncol_mat - 1;
        }
        while (!found) {
          if (j >= len - 1) {
            while (idx < len) { 
              String char_matrix = matrix.get(i+idx).get(j-idx);
              String char_word = words.get(count).get(idx);
              perbandingan++;
              if (char_matrix.equals(char_word)) {
                idx++;
              } else {
                j--;
                idx = 0;
                break;
              }
            }
          } else {
            if (i < nrow_mat - len) {
              i++;
              j = ncol_mat - 1;
            } else {
              break;
            }
          }
          if (len == idx) {
            found = true;
            kiri_bawah = true;
            count++;
          }
        }

        // pencarian dengan arah ke kanan atas
        if (!found) {
          idx = 0; i = nrow_mat - 1; j = 0;
        }
        while (!found) {
          if (j <= ncol_mat - len) {
            while (idx < len) {
              String char_matrix = matrix.get(i-idx).get(j+idx);
              String char_word = words.get(count).get(idx);
              perbandingan++;
              if (char_matrix.equals(char_word)) {
                idx++;
              } else {
                j++;
                idx = 0;
                break;
              }
            }
          } else {
            if (i >= len) {
              i--;
              j = 0;
            } else {
              break;
            }
          }
          if (len == idx) {
            found = true;
            kanan_atas = true;
            count++;
          }
        }

        // Menghitung waktu pencarian kata
        long finish_time = System.nanoTime();
        total_time = total_time + (finish_time - start_time);
        
        // Menampilkan letak kata pada puzzle
        System.out.print(count + ". Kata ");
        for (int x = 0; x < words.get(count - 1).size(); x++) {
          System.out.print(words.get(count - 1).get(x));
        }
        System.out.print(" ditemukan dengan arah ke ");
        if (kanan) {
          System.out.println("kanan pada:");
          for (int u = 0; u < nrow_mat; u++) {
            for (int v = 0; v < ncol_mat; v++) {
              if (u == i) {
                if (v >= j && v < (j + len)) {
                  System.out.print(matrix.get(u).get(v) + " ");
                } else {
                  System.out.print("- ");
                }
              } else {
                System.out.print("- ");
              }
            }
            System.out.println();
          }
        } else if (kiri) {
          System.out.println("kiri pada:");
          for (int u = 0; u < nrow_mat; u++) {
            for (int v = 0; v < ncol_mat; v++) {
              if (u == i) {
                if (v <= j && v > (j - len)) {
                  System.out.print(matrix.get(u).get(v) + " ");
                } else {
                  System.out.print("- ");
                }
              } else {
                System.out.print("- ");
              }
            }
            System.out.println();
          }
        } else if (bawah) {
          System.out.println("bawah pada:");
          for (int u = 0; u < nrow_mat; u++) {
            for (int v = 0; v < ncol_mat; v++) {
              if (v == j) {
                if (u >= i && u < (i + len)) {
                  System.out.print(matrix.get(u).get(v) + " ");
                } else {
                  System.out.print("- ");
                }
              } else {
                System.out.print("- ");
              }
            }
            System.out.println();
          }
        } else if (atas) {
          System.out.println("atas pada:");
          for (int u = 0; u < nrow_mat; u++) {
            for (int v = 0; v < ncol_mat; v++) {
              if (v == j) {
                if (u <= i && u > (i - len)) {
                  System.out.print(matrix.get(u).get(v) + " ");
                } else {
                  System.out.print("- ");
                }
              } else {
                System.out.print("- ");
              }
            }
            System.out.println();
          }
        } else if (kanan_bawah) {
          System.out.println("kanan bawah pada:");
          for (int u = 0; u < nrow_mat; u++) {
            for (int v = 0; v < ncol_mat; v++) {
              if (u >= i && u < (i + len) && v >= j && v < (j + len)) {
                if ((u - i) == (v - j)) {
                  System.out.print(matrix.get(u).get(v) + " ");
                } else {
                  System.out.print("- ");
                }
              } else {
                System.out.print("- ");
              }
            }
            System.out.println();
          }
        } else if (kiri_atas) {
          System.out.println("kiri atas pada:");
          for (int u = 0; u < nrow_mat; u++) {
            for (int v = 0; v < ncol_mat; v++) {
              if (u <= i && u > (i - len) && v <= j && v > (j - len)) {
                if ((u - i) == (v - j)) {
                  System.out.print(matrix.get(u).get(v) + " ");
                } else {
                  System.out.print("- ");
                }
              } else {
                System.out.print("- ");
              }
            }
            System.out.println();
          }
        } else if (kiri_bawah) {
          System.out.println("kiri bawah pada:");
          for (int u = 0; u < nrow_mat; u++) {
            for (int v = 0; v < ncol_mat; v++) {
              if (u >= i && u < (i + len) && v <= j && v > (j - len)) {
                if ((u - i) == (j - v)) {
                  System.out.print(matrix.get(u).get(v) + " ");
                } else {
                  System.out.print("- ");
                }
              } else {
                System.out.print("- ");
              }
            }
            System.out.println();
          }
        } else { // kanan atas
          System.out.println("ke kanan atas pada:");
          for (int u = 0; u < nrow_mat; u++) {
            for (int v = 0; v < ncol_mat; v++) {
              if (u <= i && u > (i - len) && v >= j && v < (j + len)) {
                if ((u - i) == (j - v)) {
                  System.out.print(matrix.get(u).get(v) + " ");
                } else {
                  System.out.print("- ");
                }
              } else {
                System.out.print("- ");
              }
            }
            System.out.println();
          }
        }
        System.out.println("Banyak perbandingan huruf yang dilakukan untuk menemukan kata ini adalah " + perbandingan);
        System.out.println("Waktu yang diperlukan untuk menemukan kata ini adalah " + (finish_time - start_time) + " nanoseconds");
        System.out.println();
        perbandingan_total = perbandingan_total + perbandingan;
      }
      System.out.println("Total perbandingan huruf yang dilakukan untuk menemukan semua kata adalah " + perbandingan_total);
      System.out.println("Waktu eksekusi program adalah " + total_time + " nanoseconds");
    }
  }
}
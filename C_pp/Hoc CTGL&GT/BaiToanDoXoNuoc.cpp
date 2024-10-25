#include<stdio.h>

#include<string.h>

#define max 100

int queue[3 * max + 10], last = 0, first = 0;
int change[max + 1][max + 1][max + 1], action[max * max * max], total = 0;
int resultx = 0, resulty = 0, resultz = 0, finishSuccess = 0;
int tracex[max + 1][max + 1][max + 1], tracey[max + 1][max + 1][max + 1], tracez[max + 1][max + 1][max + 1];
int X, Y, Z, T;
const char * str[] = {
     "",
     "Do day binh A :",
     "Do day binh B:",
     "Do day binh C :",
     "Do A ra ngoai :",
     "Do B ra ngoai :",
     "Do C ra ngoai :",
     "Do A-->B :",
     "Do A-->C :",
     "Do B-->A :",
     "Do B-->C :",
     "Do C-->A :",
     "Do C-->B :"
};
int changex(int x, int y, int z, int i) // hàm thay doi trang thai cua binh A
{
     switch (i) {
          //do day A
          case 1:
               return X;
               // do day B
          case 2:
               return x;
               //do day C
          case 3:
               return x;
               // do A ra ngoai
          case 4:
               return 0;
               // do B ra ngoai
          case 5:
               return x;
               //do C ra ngoai
          case 6:
               return x;
               //do A-->B
          case 7:
               return x + y <= Y ? 0 : x + y - Y;
               //do A-->C
          case 8:
               return x + z <= Z ? 0 : x + z - Z;
               //do B-->A
          case 9:
               return x + y > X ? X : x + y;
               //do B-->C
          case 10:
               return x;
               //do C-->A
          case 11:
               return x + z > X ? X : x + z;
               //do C-->B
          case 12:
               return x;
     }
}
int changey(int x, int y, int z, int i) // hàm thay doi trang thai cua binh B
{
     switch (i) {
          //do day A
          case 1:
               return y;
               // do day B
          case 2:
               return Y;
               //do day C
          case 3:
               return y;
               // do A ra ngoai
          case 4:
               return y;
               // do B ra ngoai
          case 5:
               return 0;
               //do C ra ngoai
          case 6:
               return y;
               //do A-->B
          case 7:
               return x + y > Y ? Y : x + y;
               //do A-->C
          case 8:
               return y;
               //do B-->A
          case 9:
               return x + y <= X ? 0 : x + y - X;
               //do B-->C
          case 10:
               return y + z <= Z ? 0 : y + z - Z;
               //do C-->A
          case 11:
               return y;
               //do C-->B
          case 12:
               return y + z > Y ? Y : y + z;
     }
}

int changez(int x, int y, int z, int i) // hàm thay doi trang thai cua binh C
{
     switch (i) {
          //do day A
          case 1:
               return z;
               // do day B
          case 2:
               return z;
               //do day C
          case 3:
               return Z;
               // do A ra ngoai
          case 4:
               return z;
               // do B ra ngoai
          case 5:
               return z;
               //do C ra ngoai
          case 6:
               return 0;
               //do A-->B
          case 7:
               return z;
               //do A-->C
          case 8:
               return x + z > Z ? Z : x + z;
               //do B-->A
          case 9:
               return z;
               //do B-->C
          case 10:
               return y + z > Z ? Z : y + z;
               //do C-->A
          case 11:
               return x + z <= X ? 0 : x + z - X;
               //do C-->B
          case 12:
               return y + z <= Y ? 0 : y + z - Y;
     }
}
void bfs() // su dung mang 3 chieu
{
     int ux, uy, uz, vx, vy, vz, i;
     //dua trang thai dau vao danh sach
     queue[++last] = 0;
     queue[++last] = 0;
     queue[++last] = 0;

     do {
          ux = queue[++first];
          uy = queue[++first];
          uz = queue[++first];
          for (i = 1; i <= 12; i++) // vong nay de tao ra cac trang thai tiep theo hay noi cach khac là tim cac con cua nut cha
          {

               vx = changex(ux, uy, uz, i);
               vy = changey(ux, uy, uz, i);
               vz = changez(ux, uy, uz, i);
               if (change[vx][vy][vz] == 0)
               {
                    tracex[vx][vy][vz] = ux; //danh dau ux la cha cua vx hay còn nói là luu vet
                    tracey[vx][vy][vz] = uy;
                    tracez[vx][vy][vz] = uz;

                    queue[++last] = vx;
                    queue[++last] = vy;
                    queue[++last] = vz;
                    change[vx][vy][vz] = i;
                    if (vx == T || vy == T || vz == T)
                    {
                         resultx = vx;
                         resulty = vy;
                         resultz = vz;
                         finishSuccess = 1;
                         return;
                    }
               }
          }
     } //do
     while (first < last);
}

void output()
{
     int x = resultx, y = resulty, z = resultz, x0, y0, z0, type, i;
     if (!finishSuccess)
     {
          printf("No way ! :(");
          return;
     }
     do {
          action[++total] = change[x][y][z]; // action là mang luu cac gia tri de thay doi trang thai
          x0 = tracex[x][y][z];
          y0 = tracey[x][y][z];
          z0 = tracez[x][y][z];
          x = x0;
          y = y0;
          z = z0;
     }
     while (x != 0 || y != 0 || z != 0);
     i = 1;
     printf("Bat dau 3 binh rong\n");
     while (total > 0)
     {
          type = action[total];
          x0 = changex(x, y, z, type);
          y0 = changey(x, y, z, type);
          z0 = changez(x, y, z, type);
          x = x0;
          y = y0;
          z = z0;
          printf("\nBuoc %2d : %15s %3d %3d %3d", i++, str[type], x, y, z);
          total--;
     }
     printf("\n\nSau %d buoc, ta lay duoc %d lit :D", i - 1, T);
}
int main() {

     printf("Nhap dung tich binh thu nhat (<=100) : ");
     scanf("%d", & X);
     printf("Nhap dung tich binh thu hai (<=100) : ");
     scanf("%d", & Y);
     printf("Nhap dung tich binh thu ba (<=100) : ");
     scanf("%d", & Z);
     printf("Nhap dung tich can dong (<=100) : ");
     scanf("%d", & T);
     printf("\n\n");
     printf("De bai : Co 3 binh co dung tich %d, %d va %d lit.\n", X, Y, Z);
     printf("Tim cach do de lay duoc %d lit\n=============================\n", T);
     bfs();
     output();
     return 0;
}
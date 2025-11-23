#include <stdio.h>
int main(void) {
    int x, y;
    double resultado;
    int ativo;
    {
        scanf("%d", &x);
        scanf("%d", &y);
        resultado = (x) + ((y) * (2.5));
        ativo = (x) > (y);
        if (ativo) {
            {
                printf("%lf\n", resultado);
            }
        }
        while ((x) < (10)) {
            {
                x = (x) + (1);
            }
        }
    }
    return 0;
}
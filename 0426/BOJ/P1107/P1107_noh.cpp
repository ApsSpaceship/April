#include <cmath>
#include <iostream>
using namespace std;
bool broken[10];

bool notBroken(int num) {
    if (num == 0 && broken[0])
        return false;
    while (num != 0) {
        if (broken[num % 10])
            return false;
        num /= 10;
    }
    return true;
}
int main(void) {
    int n, m;
    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int btn;
        scanf("%d", &btn);
        broken[btn] = true;
    }
    int ans = abs(n - 100);
    for (int i = 0; i <= 1000000; ++i) {
        if (!notBroken(i))
            continue;
        ans = min(ans, abs(n - i) + (i == 0 ? 0 : (int)log10(i)) + 1);
    }
    printf("%d", ans);
    return 0;
}
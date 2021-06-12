#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> g1;
    for (int i=1; i<=10; i++)
        g1.push_back(i);

    cout << "\nSize: " << g1.size();
    cout << "\nCapacity: " << g1.capacity();
    cout << "\nMax size: " << g1.max_size();
    
    cout << "\nOutput of begin and end: ";
    for (auto i=g1.begin(); i!=g1.end(); ++i)
        cout << *i << " ";
    
    return 0;
}
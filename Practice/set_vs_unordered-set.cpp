#include <algorithm>
#include <chrono>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;

void insertInSet(int a[], int n)
{
    int i, count=0;
    double dups=0;
    std::set<int> s;

    auto start = high_resolution_clock::now();          // Get starting timepoint

    for(i=0; i<n; i++)
    {
        if(s.find(a[i])==s.end())
        {
            s.insert(a[i]);
            count++;
        }
    }
    auto stop = high_resolution_clock::now();           // Get ending timepoint
	auto duration = duration_cast<microseconds>(stop - start);  // Get duration. Substart timepoints to get durarion. To cast it to proper unit use duration cast method

	cout << "\nInserted   : " << s.size() << " entries";
	dups = ((n - s.size())/(double)n);
	cout << "\nDuplicates : " << dups * 100 << " %";
	cout << "\nTime taken : "
		<< duration.count() << " microseconds" << endl;

}

void insertInUnorderedSet(int a[], int n)
{
    int i, count=0;
    double dups=0;
    std::unordered_set<int> s;

    auto start = high_resolution_clock::now();          // Get starting timepoint

    for(i=0; i<n; i++)
    {
        if(s.find(a[i])==s.end())
        {
            s.insert(a[i]);
            count++;
        }
    }
    auto stop = high_resolution_clock::now();           // Get ending timepoint
	auto duration = duration_cast<microseconds>(stop - start);  // Get duration. Substart timepoints to get durarion. To cast it to proper unit use duration cast method

	cout << "\nInserted   : " << s.size() << " entries";
	dups = ((n - s.size())/(double)n);
	cout << "\nDuplicates : " << dups * 100 << " %";
	cout << "\nTime taken : "
		<< duration.count() << " microseconds" << endl;
}

void printArray(int a[], int n)
{
    for (int i = 0; i < n; i++) {
        cout << a[i] << ", ";
    }
    printf("\n\n");
}

int main()
{
    int N = 500, ll=1, ul=1000;
    int arr[N] = {0};

    /* seed the PRNG (MT19937) using a fixed value (in our case, 0) */
    std::mt19937 generator(0);
    std::uniform_int_distribution<int> distribution(ll,ul);

    /* generate n numbers in [ll,ul] (always the same sequence!) */
    for (size_t i = 0; i < N; ++i)
    {
        arr[i] = distribution(generator);
    }

    //printArray(arr, N);

    printf("N=%d, range: [%d,%d]", N,ll,ul);
    cout << "\n\n--- Ordered set ---";
	insertInSet(arr, N);

	cout << "\n\n--- Unordered set ---";
	insertInUnorderedSet(arr, N);

	return 0;
}

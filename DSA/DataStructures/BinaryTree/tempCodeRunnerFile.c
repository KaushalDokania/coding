
// Node createTreeItr(int *arr, int len) {
//     Node node=NULL, root;
//     int height = (int)log2(len) + 1;
//     for (int i=0; i<height; ++i) {
//         if (!node)
//             node = newNode(arr[i]);
//         node->left = newNode(arr[2*i+1]);
//         node->right = newNode(arr[2*i+2]);
//     }
//     return root;
// }
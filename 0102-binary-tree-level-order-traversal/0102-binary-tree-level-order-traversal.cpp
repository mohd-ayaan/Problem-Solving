/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if(root==nullptr){return res;}

        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            int queuesize=q.size();
            vector<int> v;
            for(int i=0;i<queuesize;i++)
            {
                TreeNode* node=q.front();
                q.pop();  
                v.push_back(node->val);
                if(node->left){
                    q.push(node->left);}
                if(node->right){
                    q.push(node->right);}
            }
            res.push_back(v);
            

        }
        return res;
    }
};
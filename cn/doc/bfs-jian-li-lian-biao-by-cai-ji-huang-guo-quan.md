```
//特定深度节点链表
	public static ListNode[] listOfDepth(TreeNode tree){
		if(tree == null) return null;
		List<ListNode> resArr = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(tree);
		while(!queue.isEmpty()){
			int size = queue.size();
			ListNode node = new ListNode(0);//头节点
			ListNode head = node;
			for(int i=0;i<size;i++){
				TreeNode p = queue.poll();
				ListNode n = new ListNode(p.val);
				node.next = n;
				node = n;
				if(p.left != null) queue.add(p.left);
				if(p.right != null) queue.add(p.right);
			}
			resArr.add(head.next);
		}
		return resArr.toArray(new ListNode[resArr.size()]);
	}
```

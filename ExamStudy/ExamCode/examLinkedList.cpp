#include "LinkedList.h"

LinkedList::LinkedList()
{
	Node *head = nullptr;
}

bool LinkedList::isEmpty()
{
	bool output = false;
	if (head == nullptr)
	{
		output = true;
	}
	return output;
}

void LinkedList::addFront(int newData)
{
	Node *newNode = new Node(newData, head);
	if (isEmpty())
	{
		head = newNode;
	}
	else
	{
		newNode->setNext(head);
	}
}

void LinkedList::deleteFront()
{
	if (!isEmpty())
	{
		Node *temp = head;
		head = head->getNext();
		delete temp;
	}
}

void LinkedList::addNode(int newData, int addData) //Add newData after addData
{
	if (isEmpty())
	{
		addFront(newData);
	}
	else
	{
		Node *currNode = head;
		while (currNode != nullptr)
		{
			if (currNode->getData() == addData)
			{
				Node *newNode = new Node(newData, currNode->getNext());
				currNode->setNext(newNode);
			}
			currNode = currNode->getNext();
		}
	}
}

void LinkedList::deleteNode(int deleteData)
{
	if (!isEmpty())
	{
		if (head->getData() == deleteData)
		{
			deleteFront();
		}
		else
		{
			Node *currNode = head->getNext();
			while (currNode != nullptr)
			{
				if (currNode->getNext()->getData() == deleteData)
				{
					Node *temp = currNode->getNext();
					currNode->setNext(currNode->getNext()->getNext());
					delete temp;
				}
				currNode = currNode->getNext();
			}
		}
	}
}

void LinkedList::addAtIndex(int index, int newData)
{
	if(isEmpty())
	{
		addFront(newNode);
	}
	else
	{
		Node *currNode = head;
		int count = 0;
		while (currNode != nullptr)
		{
			++count;
			currNode = currNode->getNext();
		}
		currNode = head;
		if (index <= count - 1)
		{
			while (index != 0)
			{
				currNode = currNode->getNext();
				--index;
			}
			Node *newNode = new Node(newData, currNode->getNext());
			currNode->setNext(newNode);
		}
	}
}
void LinkedList::deleteAtIndex(int index)
{
	if (!isEmpty())
	{
		Node *currNode = head;
		int count = 0;
		while (currNode != nullptr)
		{
			++count;
			currNode = currNode->getNext();
		}
		currNode = head;
		if (index <= count - 1)
		{
			while (index != 1)
			{
				currNode = currNode->getNext();
				--index;
			}
			Node *temp = currNode()->getNext();
			currNode->setNext(currNode->getNext()->getNext());
			delete temp;
		}
	}
}
void LinkedList::addBack(int newData)
{
	Node *newNode = new Node(newData, nullptr);
	if(isEmpty())
	{
		addFront(newNode);
	}
	else
	{
		Node *currNode = head;
		while (currNode->getNext() != nullptr)
		{
			currNode = currNode->getNext();
		}
		currNode->setNext(newNode);
	}
}

void LinkedList::deleteBack()
{
	if (!isEmpty())
	{
		while (currNode->getNext() != null)
		{
			currNode = currNode->getNext();
		}
		delete currNode;
	}
}

void LinkedList::addBack()
{

}
// void LinkedList::deleteBack()
// {
// 	if(!isEmpty())
// 	{
// 		Node* temp = tail;
// 		tail = tail->getPrev();
// 		delete tail;
// 	}
// }
package bookStoreSpring2AdamSmithLUC.model.order;

import bookStoreSpring2AdamSmithLUC.model.product.Book;
import bookStoreSpring2AdamSmithLUC.model.product.Product;

public interface OrderDetail {
	public Book getBook();
	public void setBook(Book product);
	public int getQuantity();
	public void setQuantity(int quantity);
}

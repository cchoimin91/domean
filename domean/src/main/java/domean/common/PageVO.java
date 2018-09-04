package domean.common;

public class PageVO {
	private Integer startRow;
	private Integer endRow;
	private Integer displayRowCount=10;
	private Integer page;
	private Integer totPage;
	private Integer totRow=0;
	private Integer sPage;
	private Integer ePage; 

	/**
	 * 페이징 처리
	 * @param total 전체카우트를 넘깁니다.
	 */
	public void PageCalculate(Integer total) {
		
		getPage();
		
		totRow  = total;
		totPage	= (int) ( total / displayRowCount );
		
		if ( total % displayRowCount > 0 ) totPage++;
		
		sPage = (page - (page - 1) % 10) ;
		ePage = sPage + 9;
		if (ePage > totPage){
			ePage = totPage;
		}
		
		startRow = ((page - 1) * displayRowCount) + 1 ;
		endRow   = startRow + displayRowCount -1;
	} 
	
    
	public Integer getPage() {
		if (page==null || page==0){
			page=1;
		}
		
		return page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotRow() {
		return totRow;
	}

	public void setTotRow(Integer totRow) {
		this.totRow = totRow;
	}

	public Integer getTotPage() {
		return totPage;
	}

	public void setTotPage(Integer totPage) {
		this.totPage = totPage;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	public Integer getDisplayRowCount() {
		return displayRowCount;
	}

	public void setDisplayRowCount(Integer displayRowCount) {
		this.displayRowCount = displayRowCount;
	}

	public Integer getsPage() {
		return sPage;
	}

	public void setsPage(Integer sPage) {
		this.sPage = sPage;
	}

	public Integer getePage() {
		return ePage;
	}

	public void setePage(Integer ePage) {
		this.ePage = ePage;
	}

	
}



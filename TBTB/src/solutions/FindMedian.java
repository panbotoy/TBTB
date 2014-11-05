package solutions;

public class FindMedian {

	/**
	 * @param args
	 */
    public double findMedianSortedArraysIter(int A[], int B[]) {
        if (A == null && B == null) return -1;
        if (A.length == 0 && B.length == 0) return -1;
        
        if (A.length > B.length) {
        	int [] tmp;
        	tmp = A;
        	A = B;
        	B = tmp;
        } 
        
        if (A.length == 0) {
        	if (B.length % 2 == 0) {
        		return 1.0 * (B[B.length/2 - 1] + B[B.length/2]) / 2;
        	} else return B[B.length/2];
        }
        
        int Astart = 0;
        int Aend = A.length - 1;
        int Bstart = 0;
        int Bend = B.length - 1;
        
        while(Astart < Aend && Bstart < Bend){
        	int Alen = (int)Math.floor(1.0 *(Aend - Astart + 1)/2);
        	double Amed = this.median(A, Astart, Aend);
        	double Bmed = this.median(B, Bstart, Bend);
        	
        	if (Amed == Bmed) return Amed;
        	if (Amed < Bmed){
        		Astart += Alen;
        		Bend -= Alen;
        	} else {
        		Aend -= Alen;
        		Bstart += Alen;
        	}
        }
    	double Bmed = this.median(B, Bstart, Bend);
    	int Bmid = (Bstart + Bend)/2;
    	if (A[Astart] == Bmed){
    		return A[Astart];
    	}
    	if (Bstart == Bend) return 1.0 * (A[Astart] + B[Bstart]) / 2;
    	if (A[Astart] < B[Bmid]){
    		if ((Bend - Bstart) %2 == 0) {   // B is odd
        		int mid1 =  A[Astart] < B[Bmid-1] ? B[Bmid-1] : A[Astart];
        		return 1.0 * (mid1 + B[Bmid]) / 2;
        	}
    		else return B[Bmid];
    	} else {
			if ((Bend - Bstart) %2 == 0) {
				int mid1 = A[Astart] < B[Bmid+1] ? A[Astart] : B[Bmid+1];
				return 1.0 * (mid1 + B[Bmid]) / 2;
			}    // B is odd
			else {
				return A[Astart] < B[Bmid+1] ? A[Astart] : B[Bmid+1];
			}
    	}
    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null && B == null) return -1;
        if (A.length == 0 && B.length == 0) return -1;
        if (A.length > B.length) {
        	int [] tmp;
        	tmp = A;
        	A = B;
        	B = tmp;
        } 
    	if ((A.length + B.length) % 2 == 0){
    		return 1.0 * (this.findNumber(A, B, (A.length + B.length)/2) + this.findNumber(A, B, (A.length + B.length)/2 + 1))/2;
    	} else {
    		return this.findNumber(A, B, (A.length + B.length) /2 + 1);
    	}
    }
    
    private int findNumber(int A[], int B[], int k){
    	int Astart = 0;
        int Aend = A.length - 1;
        int Bstart = 0;
        int Bend = B.length - 1;
        while ( k > 1 && Aend>=Astart && Bend>=Bstart){
        	int Amid = (Astart + Aend) / 2;
        	double Alen = Aend - Astart + 1;
        	int Bmid = (Bstart + Bend) / 2;
        	double Blen = Bend - Bstart + 1; 
        	if (1.0 * Alen/2 + 1.0 * Blen/2 < k){
        		if (A[Amid] < B[Bmid]){ // drop section 1
        			int shift = Amid-Astart>0 ? Amid-Astart : 1;
        			k -= shift;
        			Astart += shift;
        		}else{
        			int shift = Bmid-Bstart > 0 ? Bmid - Bstart : 1;
        			k = k - shift;
        			Bstart += shift;
        		}
        	}else {
        		if (A[Amid] < B[Bmid]){
        			int shift = Bend - Bmid > 0 ? Bend - Bmid : 1;
        			Bend -= shift;
        		}else{
        			int shift = Aend - Amid > 0 ? Aend - Amid : 1;
        			Aend -= shift;
        		}
        	}
        }
    	if (Aend - Astart < 0) return B[Bstart + k - 1];
    	else if (Bend - Bstart < 0) return A[Astart + k -1];
    	else return Math.min(A[Astart], B[Bstart]); 
    }
    
    private int findNumberII(int A[], int B[], int k){
    	int Astart = 0;
        int Aend = A.length - 1;
        int Bstart = 0;
        int Bend = B.length - 1;
        while ( k > 1 && Aend>=Astart && Bend>=Bstart){
        	int Amid = (Astart + Aend) / 2;
        	double Alen = Aend - Astart + 1;
        	int Bmid = (Bstart + Bend) / 2;
        	double Blen = Bend - Bstart + 1; 
        	if ((Alen + Blen)/2 <= k){
        		if (A[Amid] < B[Bmid]){ // drop section 1
        			
        			k = k - (Amid - Astart + 1);
        			Astart = Amid + 1;
        		}else{
        			
        			k = k - (Bmid - Bstart + 1);
        			Bstart = Bmid + 1;
        		}
        	}else {
        		if (A[Amid] < B[Bmid]){
        			Bend = Bmid - 1;
        		}else{
        			Aend = Amid - 1;
        		}
        	}
        }
    	if (Aend < Astart) return B[Bstart + k - 1];
    	else if (Bend < Bstart) return A[Astart + k -1];
    	else return Math.min(A[Astart], B[Bstart]); 
    }
    
    private double median(int [] A, int start, int end){
    	if ((end - start) % 2  == 0) {
    		return A[start + (end - start)/2];    		
    	} else {
    		int med1 = A[start + (end - start)/2];
    		int med2 = A[start + (end - start)/2 + 1];
    		return 1.0 * (med1 + med2) /2;
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedian mid = new FindMedian();
		int [] A = new int [] {1};
		int [] B = new int [] {1};
		System.out.println(mid.findNumberII(A, B, 2));
	}

}

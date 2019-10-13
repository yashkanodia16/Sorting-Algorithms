
public class QuickSortMedian{

	public void quicksort( Comparable [ ] a ) {
		quicksortmed( a, 0, a.length - 1 );
	}

	private static final int CUTOFF = 10;

	private static void quicksortmed( Comparable[] a, int first, int last ) {
		if( first + CUTOFF > last )
			insertionSort( a, first, last );
		else {
			// Sort low, middle, high
			int middle = ( first + last ) / 2;
			if( a[ middle ].compareTo( a[ first ] ) < 0 )
				swap( a, first, middle );
			if( a[ last ].compareTo( a[ first ] ) < 0 )
				swap( a, first, last );
			if( a[last ].compareTo( a[ middle ] ) < 0 )
				swap( a, middle, last );

			// Place pivot at position high - 1
			swap( a, middle, last - 1 );
			Comparable pivot = a[ last - 1 ];

			int i, j;
			for( i = first, j = last - 1; ; ) {
				while( a[ ++i ].compareTo( pivot ) < 0 )
					;
				while( pivot.compareTo( a[ --j ] ) < 0 )
					;
				if( i >= j )
					break;
				QuickSortMedian.swap( a, i, j );
			}

			swap( a, i, last - 1 );

			quicksortmed( a, first, i - 1 );
			quicksortmed( a, i + 1, last );
		}
	}



	private static void insertionSort( Comparable [ ] a, int low, int high ) {
		for (int p = low + 1; p <= high; p++) {
			Comparable tmp = a[p];
			int j;

			for (j = p; j > low && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	public static final void swap( Object [ ] a, int index1, int index2 ) {
		Object tmp = a[ index1 ];
		a[ index1 ] = a[ index2 ];
		a[ index2 ] = tmp;
	}

}
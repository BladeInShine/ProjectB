use warnings;

my $filename = 'DeathRecords.csv';
#my $outfilename = 'try_natual_death.csv';
my $outfilename = 'try_maner_of_death.csv';
open(my $data, '<', $filename) or die "could not open '$filename' $!\n";
open(my $output, '>', $outfilename) or die "could not open '$outfilename' $!\n";


while (my $line = <$data>){
  chomp $line;

  my @fields = split ",", $line;
  if($fields[19]==7)
#resident1 Education3, sex6,age12, Marital15, ManerofDeath19,Activity22, Icd24, Race31
  {
  print $output "$fields[1],$fields[3],$fields[6],$fields[12],$fields[15],1,$fields[31]\n";
  }
  else
  {
  print $output "$fields[1],$fields[3],$fields[6],$fields[12],$fields[15],0,$fields[31]\n";
  }
  # print "$ave---------$count\n";

}
#print $line;


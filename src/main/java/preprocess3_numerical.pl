use warnings;

my $filename = 'DeathRecords.csv';
my $outfilename = 'try2_numerical.csv';
open(my $data, '<', $filename) or die "could not open '$filename' $!\n";
open(my $output, '>', $outfilename) or die "could not open '$outfilename' $!\n";


while (my $line = <$data>){
  chomp $line;

  my @fields = split ",", $line;

#natual death
if($fields[19]==7)
{
  if($fields[6]eq'M')
  {
	print $output "1,$fields[8]\n";

  }
  else
  {
	print $output "0,$fields[8]\n";
  }
}
#male, female, age
#Education, sex,age12, Marital15, Activity22, Icd24, Race31


}



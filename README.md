To add your Scala group to http://scala.space, add a single-line array to the collection in groups.js with the following five elements, in order: group name, Meetup group ID or full URL, latitude and longitude of the place where you usually meet, and `true` if the group is a purely Scala group, or `false` if it's a more general FP group.

The easiest way to find these is to do a Google search for "coordinates of [place name]", and to reformat the response as real numbers, remembering to negate longitudes in the Western Hemisphere, and latitudes in the Southern Hemisphere.

For example, searching for "coordinates of Brighton" returns the response "50.8429° N, 0.1313° W". This should be translated to the entry ```['Brighton Scala Users Group', 'http://example.com/', 50.8429, -0.1313, true]```.

Try to keep the locations in alphabetical order of name.
